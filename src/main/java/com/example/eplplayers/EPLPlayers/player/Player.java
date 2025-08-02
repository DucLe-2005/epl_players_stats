package com.example.eplplayers.EPLPlayers.player;

import jakarta.persistence.*;

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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setAge(Float age) {
        this.age = age;
    }

    public void setMp(Float mp) {
        this.mp = mp;
    }

    public void setStarts(Float starts) {
        this.starts = starts;
    }

    public void setMinutes(Float minutes) {
        this.minutes = minutes;
    }

    public void setNineties(Float nineties) {
        this.nineties = nineties;
    }

    public void setGoals(Float goals) {
        this.goals = goals;
    }

    public void setAssists(Float assists) {
        this.assists = assists;
    }

    public void setGoals_plus_assists(Float goals_plus_assists) {
        this.goals_plus_assists = goals_plus_assists;
    }

    public void setGoals_non_penalty(Float goals_non_penalty) {
        this.goals_non_penalty = goals_non_penalty;
    }

    public void setPenalties(Float penalties) {
        this.penalties = penalties;
    }

    public void setPenalties_attempted(Float penalties_attempted) {
        this.penalties_attempted = penalties_attempted;
    }

    public void setYellow_cards(Float yellow_cards) {
        this.yellow_cards = yellow_cards;
    }

    public void setRed_cards(Float red_cards) {
        this.red_cards = red_cards;
    }

    public void setXg(Float xg) {
        this.xg = xg;
    }

    public void setNpxg(Float npxg) {
        this.npxg = npxg;
    }

    public void setXag(Float xag) {
        this.xag = xag;
    }

    public void setNpxg_plus_xag(Float npxg_plus_xag) {
        this.npxg_plus_xag = npxg_plus_xag;
    }

    public void setProg_carries(Float prog_carries) {
        this.prog_carries = prog_carries;
    }

    public void setProg_passes(Float prog_passes) {
        this.prog_passes = prog_passes;
    }

    public void setProg_receives(Float prog_receives) {
        this.prog_receives = prog_receives;
    }

    public void setGoals_per90(Float goals_per90) {
        this.goals_per90 = goals_per90;
    }

    public void setAssists_per90(Float assists_per90) {
        this.assists_per90 = assists_per90;
    }

    public void setG_plus_a_per90(Float g_plus_a_per90) {
        this.g_plus_a_per90 = g_plus_a_per90;
    }

    public void setGoals_non_pk_per90(Float goals_non_pk_per90) {
        this.goals_non_pk_per90 = goals_non_pk_per90;
    }

    public void setG_plus_a_non_pk_per90(Float g_plus_a_non_pk_per90) {
        this.g_plus_a_non_pk_per90 = g_plus_a_non_pk_per90;
    }

    public void setXg_per90(Float xg_per90) {
        this.xg_per90 = xg_per90;
    }

    public void setXag_per90(Float xag_per90) {
        this.xag_per90 = xag_per90;
    }

    public void setXg_plus_xag_per90(Float xg_plus_xag_per90) {
        this.xg_plus_xag_per90 = xg_plus_xag_per90;
    }

    public void setNpxg_per90(Float npxg_per90) {
        this.npxg_per90 = npxg_per90;
    }

    public void setNpxg_plus_xag_per90(Float npxg_plus_xag_per90) {
        this.npxg_plus_xag_per90 = npxg_plus_xag_per90;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public String getNation() {
        return nation;
    }

    public Integer getId() {
        return id;
    }

    public String getPosition() {
        return position;
    }

    public Float getAge() {
        return age;
    }

    public Float getMp() {
        return mp;
    }

    public Float getStarts() {
        return starts;
    }

    public Float getMinutes() {
        return minutes;
    }

    public Float getNineties() {
        return nineties;
    }

    public Float getGoals() {
        return goals;
    }

    public Float getAssists() {
        return assists;
    }

    public Float getGoals_plus_assists() {
        return goals_plus_assists;
    }

    public Float getGoals_non_penalty() {
        return goals_non_penalty;
    }

    public Float getPenalties() {
        return penalties;
    }

    public Float getPenalties_attempted() {
        return penalties_attempted;
    }

    public Float getYellow_cards() {
        return yellow_cards;
    }

    public Float getRed_cards() {
        return red_cards;
    }

    public Float getXg() {
        return xg;
    }

    public Float getNpxg() {
        return npxg;
    }

    public Float getXag() {
        return xag;
    }

    public Float getNpxg_plus_xag() {
        return npxg_plus_xag;
    }

    public Float getProg_carries() {
        return prog_carries;
    }

    public Float getProg_passes() {
        return prog_passes;
    }

    public Float getProg_receives() {
        return prog_receives;
    }

    public Float getGoals_per90() {
        return goals_per90;
    }

    public Float getAssists_per90() {
        return assists_per90;
    }

    public Float getG_plus_a_per90() {
        return g_plus_a_per90;
    }

    public Float getGoals_non_pk_per90() {
        return goals_non_pk_per90;
    }

    public Float getG_plus_a_non_pk_per90() {
        return g_plus_a_non_pk_per90;
    }

    public Float getXg_per90() {
        return xg_per90;
    }

    public Float getXag_per90() {
        return xag_per90;
    }

    public Float getXg_plus_xag_per90() {
        return xg_plus_xag_per90;
    }

    public Float getNpxg_per90() {
        return npxg_per90;
    }

    public Float getNpxg_plus_xag_per90() {
        return npxg_plus_xag_per90;
    }

    public String getTeam() {
        return team;
    }


}
