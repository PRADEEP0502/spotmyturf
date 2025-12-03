package com.spotmyturf.backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "match_entity")
public class MatchEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teamA;
    private String teamB;
    private Integer overs;
    private String ground;
    private String status; // CREATED / LIVE / COMPLETED
    private LocalDateTime createdAt = LocalDateTime.now();

    private Integer totalRuns = 0;
    private Integer totalWickets = 0;
    private Double currentOvers = 0.0;

    public Long getId() { return id; }
    public String getTeamA() { return teamA; }
    public void setTeamA(String t) { this.teamA = t; }
    public String getTeamB() { return teamB; }
    public void setTeamB(String t) { this.teamB = t; }
    public Integer getOvers() { return overs; }
    public void setOvers(Integer o) { this.overs = o; }
    public String getGround() { return ground; }
    public void setGround(String g) { this.ground = g; }
    public String getStatus() { return status; }
    public void setStatus(String s) { this.status = s; }
    public Integer getTotalRuns() { return totalRuns; }
    public void setTotalRuns(Integer r) { this.totalRuns = r; }
    public Integer getTotalWickets() { return totalWickets; }
    public void setTotalWickets(Integer w) { this.totalWickets = w; }
    public Double getCurrentOvers() { return currentOvers; }
    public void setCurrentOvers(Double o) { this.currentOvers = o; }
}
