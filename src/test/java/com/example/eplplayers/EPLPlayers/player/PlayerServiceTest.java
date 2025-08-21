package com.example.eplplayers.EPLPlayers.player;

import com.example.eplplayers.EPLPlayers.model.Player;
import com.example.eplplayers.EPLPlayers.repository.PlayerRepository;
import com.example.eplplayers.EPLPlayers.service.PlayerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PlayerServiceTest {

    private PlayerRepository playerRepository;
    private PlayerService playerService;

    @BeforeEach
    void setup() {
        playerRepository = mock(PlayerRepository.class);
        playerService = new PlayerService(playerRepository);
    }

    @Test
    void testGetPlayers_returnsAllPlayers() {
        List<Player> mockPlayers = Arrays.asList(
                new Player("Anh 7"),
                new Player("Haaland")
        );
        when(playerRepository.findAll()).thenReturn(mockPlayers);

        List<Player> result = playerService.getPlayers();

        assertEquals(2, result.size());
    }

    @Test
    void testGetPlayers_returnsPlayersFromTeam() {
        List<Player> mockPlayers = Arrays.asList(
                new Player("ruler", "korea", "ad", "gengu"),
                new Player("chovy", "korea", "mid", "GeNgu"),
                new Player("anh 7", "portugal", "goat", "a rap xe ut")
        );

        when(playerRepository.findAll()).thenReturn(mockPlayers);

        List<Player> result = playerService.getPlayersFromTeam("gengu");

        assertEquals(2, result.size());
    }

    @Test
    void testGetPlayers_returnsPlayersByName() {
        List<Player> mockPlayers = Arrays.asList(
                new Player("faker"),
                new Player("uzi"),
                new Player("gengu")
        );
        when(playerRepository.findAll()).thenReturn(mockPlayers);

        List<Player> result = playerService.getPlayersByName("faker");

        assertEquals("faker", result.getFirst().getName());
    }

    @Test
    void testGetPlayers_returnsPlayersByPos() {
        List<Player> mockPlayers = Arrays.asList(
                new Player("Anh 7", "Portugal", "forward"),
                new Player("Haaland", "england", "forward"),
                new Player("chovy", "Korea", "farmer")
        );

        when(playerRepository.findAll()).thenReturn(mockPlayers);

        List<Player> result = playerService.getPlayersByPos("forward");

        assertEquals(2, result.size());
    }

    @Test
    void testGetPlayers_returnsPlayersByNation() {
        List<Player> mockPlayers = Arrays.asList(
                new Player("Anh 7", "Portugal", "forward"),
                new Player("Haaland", "england", "forward"),
                new Player("chovy", "Korea", "farmer"),
                new Player("harry potter", "England", "sorcerer")
        );

        when(playerRepository.findAll()).thenReturn(mockPlayers);

        List<Player> result = playerService.getPlayersByNation("England");

        assertEquals(2, result.size());
    }

    @Test
    void testGetPlayers_returnsPlayersByNationAndPosition() {
        List<Player> mockPlayers = Arrays.asList(
                new Player("faker", "kor", "mid", "T1"),
                new Player("chovy", "kor", "mid", "gengu"),
                new Player("keria", "kor", "sp", "T1"),
                new Player("ruler",  "kor", "mid", "gengu")
        );

        when(playerRepository.findAll()).thenReturn(mockPlayers);

        List<Player> result = playerService.getPlayersByTeamAndPosition("t1", "mid");

        assertEquals(1, result.size());
        assertEquals("faker", result.getFirst().getName());
        assertEquals("mid", result.getFirst().getPosition());
        assertEquals("T1", result.getFirst().getTeam());
    }
}

