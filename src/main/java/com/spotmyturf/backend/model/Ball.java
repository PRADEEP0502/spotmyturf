package com.spotmyturf.backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Ball {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long matchId;
    private Long batsmanId;
    private Long bowlerId;

    private Integer runs;
    private Boolean isWicket;
    private Integer overNumber;
    private Integer ballNumber;

    private LocalDateTime createdAt = LocalDateTime.now();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getMatchId() { return matchId; }
    public void setMatchId(Long matchId) { this.matchId = matchId; }

    public Long getBatsmanId() { return batsmanId; }
    public void setBatsmanId(Long batsmanId) { this.batsmanId = batsmanId; }

    public Long getBowlerId() { return bowlerId; }
    public void setBowlerId(Long bowlerId) { this.bowlerId = bowlerId; }

    public Integer getRuns() { return runs; }
    public void setRuns(Integer runs) { this.runs = runs; }

    public Boolean getIsWicket() { return isWicket; }
    public void setIsWicket(Boolean isWicket) { this.isWicket = isWicket; }

    public Integer getOverNumber() { return overNumber; }
    public void setOverNumber(Integer overNumber) { this.overNumber = overNumber; }

    public Integer getBallNumber() { return ballNumber; }
    public void setBallNumber(Integer ballNumber) { this.ballNumber = ballNumber; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
