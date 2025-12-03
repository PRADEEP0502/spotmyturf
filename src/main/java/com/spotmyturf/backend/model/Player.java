package com.spotmyturf.backend.model;

import jakarta.persistence.*;

@Entity
public class Player {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long matchId;
    private String name;
    private String team; // A or B

    public Long getId() { return id; }
    public Long getMatchId() { return matchId; }
    public void setMatchId(Long id) { this.matchId = id; }
    public String getName() { return name; }
    public void setName(String n) { this.name = n; }
    public String getTeam() { return team; }
    public void setTeam(String t) { this.team = t; }
}
