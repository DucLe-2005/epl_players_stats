package com.example.eplplayers.EPLPlayers.repository;

import com.example.eplplayers.EPLPlayers.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Integer> {

    void deleteByName(String playerName);

    Optional<Player> findByName(String name);
}
