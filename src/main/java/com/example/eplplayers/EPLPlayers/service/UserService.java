package com.example.eplplayers.EPLPlayers.service;

import com.example.eplplayers.EPLPlayers.model.User;
import com.example.eplplayers.EPLPlayers.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> allUsers() {
        return new ArrayList<>(userRepository.findAll());
    }
}
