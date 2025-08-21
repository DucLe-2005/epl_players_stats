package com.example.eplplayers.EPLPlayers.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="player_stats")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Integer id;
    private String name;
    private String nation;
    private String position;
    private Float age;
    private Float mp;
    private Float starts;
    private Float minutes;
    private Float nineties;
    private Float goals;
    private Float assists;
    private Float goals_plus_assists;
    private Float goals_non_penalty;
    private Float penalties;
    private Float penalties_attempted;
    private Float yellow_cards;
    private Float red_cards;
    private Float xg;
    private Float npxg;
    private Float xag;
    private Float npxg_plus_xag;
    private Float prog_carries;
    private Float prog_passes;
    private Float prog_receives;
    private Float goals_per90;
    private Float assists_per90;
    private Float g_plus_a_per90;
    private Float goals_non_pk_per90;
    private Float g_plus_a_non_pk_per90;
    private Float xg_per90;
    private Float xag_per90;
    private Float xg_plus_xag_per90;
    private Float npxg_per90;
    private Float npxg_plus_xag_per90;
    private String team;

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, String nation, String position) {
        this.name = name;
        this.nation = nation;
        this.position = position;
    }

    public Player(String name, String nation, String position, String team) {
        this.name = name;
        this.nation = nation;
        this.position = position;
        this.team = team;
    }

    public Player(String team, Float npxg_plus_xag_per90, Float npxg_per90, Float xg_plus_xag_per90, Float xag_per90, Float xg_per90, Float g_plus_a_non_pk_per90, Float goals_non_pk_per90, Float g_plus_a_per90, Float assists_per90, Float goals_per90, Float prog_receives, Float prog_passes, Float prog_carries, Float npxg_plus_xag, Float xag, Float npxg, Float xg, Float red_cards, Float yellow_cards, Float penalties_attempted, Float penalties, Float goals_non_penalty, Float goals_plus_assists, Float assists, Float goals, Float nineties, Float minutes, Float starts, Float mp, Float age, String position, String nation, String name, Integer id) {
        this.team = team;
        this.npxg_plus_xag_per90 = npxg_plus_xag_per90;
        this.npxg_per90 = npxg_per90;
        this.xg_plus_xag_per90 = xg_plus_xag_per90;
        this.xag_per90 = xag_per90;
        this.xg_per90 = xg_per90;
        this.g_plus_a_non_pk_per90 = g_plus_a_non_pk_per90;
        this.goals_non_pk_per90 = goals_non_pk_per90;
        this.g_plus_a_per90 = g_plus_a_per90;
        this.assists_per90 = assists_per90;
        this.goals_per90 = goals_per90;
        this.prog_receives = prog_receives;
        this.prog_passes = prog_passes;
        this.prog_carries = prog_carries;
        this.npxg_plus_xag = npxg_plus_xag;
        this.xag = xag;
        this.npxg = npxg;
        this.xg = xg;
        this.red_cards = red_cards;
        this.yellow_cards = yellow_cards;
        this.penalties_attempted = penalties_attempted;
        this.penalties = penalties;
        this.goals_non_penalty = goals_non_penalty;
        this.goals_plus_assists = goals_plus_assists;
        this.assists = assists;
        this.goals = goals;
        this.nineties = nineties;
        this.minutes = minutes;
        this.starts = starts;
        this.mp = mp;
        this.age = age;
        this.position = position;
        this.nation = nation;
        this.name = name;
        this.id = id;
    }

    public Player() {
    }
}
