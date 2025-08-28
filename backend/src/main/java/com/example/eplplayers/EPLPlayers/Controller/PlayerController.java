package com.example.eplplayers.EPLPlayers.Controller;

import com.example.eplplayers.EPLPlayers.model.Player;
import com.example.eplplayers.EPLPlayers.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/player")
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getPlayers(
            @RequestParam(required = false) String team,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String position,
            @RequestParam(required = false) String nation){
        if (team != null && position != null) {
            return playerService.getPlayersByTeamAndPosition(team, position);
        }
        else if (team != null) {
            return playerService.getPlayersFromTeam(team);
        }
        else if (name != null) {
            return playerService.getPlayersByName(name);
        }
        else if (position != null) {
            return playerService.getPlayersByPos(position);
        }
        else if (nation != null) {
            return playerService.getPlayersByNation(nation);
        } else {
            return playerService.getPlayers();
        }
    }

    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody Player player){
        Player createdPlayer =  playerService.addPlayer(player);
        return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
    }
}
