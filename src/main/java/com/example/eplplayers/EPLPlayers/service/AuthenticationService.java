package com.example.eplplayers.EPLPlayers.service;

import com.example.eplplayers.EPLPlayers.dto.LoginUserDto;
import com.example.eplplayers.EPLPlayers.dto.RegisterUserDto;
import com.example.eplplayers.EPLPlayers.dto.VerifyUserDto;
import com.example.eplplayers.EPLPlayers.model.User;
import com.example.eplplayers.EPLPlayers.repository.UserRepository;
import jakarta.mail.MessagingException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final EmailService emailService;

    public AuthenticationService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager,
            EmailService emailService
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.emailService = emailService;
    }

    public User signUp(RegisterUserDto input) {
        userRepository.findByEmail(input.getEmail()).ifPresent(user -> {
            throw new RuntimeException("User with this email already exists. Please login.");
        });
        User user = new User(input.getUsername(), input.getEmail(), passwordEncoder.encode(input.getPassword()));
        user.setVerificationCode(generateVerificationCode());
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        user.setVerificationExpiresAt(LocalDateTime.now().plusMinutes(15));
        user.setEnabled(false);
        sendVerificationEmail(user);
        return userRepository.save(user);
    }

    public User authenticate(LoginUserDto input) {
         User user = userRepository.findByEmail(input.getEmail())
                 .orElseThrow(() -> new RuntimeException("User not found"));

         if (!user.isEnabled()){
             throw new RuntimeException("Account not verified. Please verify your account");
         }
         authenticationManager.authenticate(
                 new UsernamePasswordAuthenticationToken(
                         input.getEmail(),
                         input.getPassword()
                 )
         );

         return user;
    }

    public void verifyUser(VerifyUserDto input) {
        Optional<User> optionalUser = userRepository.findByEmail(input.getEmail());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.isEnabled()) {
                throw new RuntimeException("Account is already verified");
            }
            if (user.getVerificationExpiresAt().isBefore(LocalDateTime.now())) {
                throw new RuntimeException("Verification expired");
            }
            if (user.getVerificationCode().equals(input.getVerificationCode())) {
                user.setEnabled(true);
                user.setVerificationCode(null);
                user.setVerificationExpiresAt(null);
                userRepository.save(user);
            } else {
                throw new RuntimeException("Wrong verification code");
            }
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public void resendVerificationCode(String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.isEnabled()) {
                throw new RuntimeException("Account is already verified");
            }
            user.setVerificationCode(generateVerificationCode());
            user.setVerificationExpiresAt(LocalDateTime.now().plusMinutes(15));
            sendVerificationEmail(user);
            userRepository.save(user);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public void sendVerificationEmail(User user) {
        String subject = "Account verification";
        String verificationCode = user.getVerificationCode();
        String to = user.getEmail();

//        String verifyURL = "http://yourdomain.com/verify?code=" + verificationCode;

        String htmlMessage = "<!DOCTYPE html>"
                + "<html><head><meta charset='UTF-8'></head><body style='font-family: Arial, sans-serif; background-color: #f4f4f4; padding: 20px;'>"
                + "<div style='max-width: 600px; margin: auto; background-color: #ffffff; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0,0,0,0.1);'>"
                + "<h2 style='color: #333;'>Hello " + user.getUsername() + ",</h2>"
//                + "<p style='font-size: 16px; color: #555;'>Thank you for registering. Please verify your account by clicking the button below:</p>"
//                + "<p style='text-align: center; margin: 30px 0;'>"
//                + "<a href='" + verifyURL + "' style='background-color: #007bff; color: white; padding: 12px 20px; text-decoration: none; border-radius: 5px;'>Verify Account</a>"
//                + "</p>"
//                + "<p style='font-size: 16px; color: #555;'>If the button above doesn't work, copy and paste the following link into your browser:</p>"
//                + "<p style='font-size: 14px; color: #777; word-break: break-all;'>" + verifyURL + "</p>"
//                + "<hr style='margin: 30px 0;'>"
                + "<p style='font-size: 16px; color: #333;'>Your verification code:</p>"
                + "<p style='font-size: 20px; font-weight: bold; color: #007bff;'>" + verificationCode + "</p>"
                + "<p style='font-size: 14px; color: #999;'>If you did not create an account, please ignore this email.</p>"
                + "<p style='font-size: 14px; color: #999;'>– The YourApp Team</p>"
                + "</div></body></html>";
        
        try {
            emailService.sendVerificationEmail(to, subject, htmlMessage);
        } catch (MessagingException e){
            e.printStackTrace();
        }
    }

    private String generateVerificationCode() {
        Random random = new Random();
        int code = random.nextInt(900000) + 100000;
        return String.valueOf(code);
    }
}
