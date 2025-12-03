package com.spotmyturf.backend.model;

import jakarta.persistence.*;

@Entity
public class PlayerStats {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long matchId;
    private Long playerId;

    private Integer runs = 0;
    private Integer balls = 0;
    private Integer fours = 0;
    private Integer sixes = 0;

    private Integer wickets = 0;
    private Integer runsGiven = 0;
    private Double oversBowled = 0.0;

    private Boolean isOut = false;

    public Long getId() { return id; }
    public Long getMatchId() { return matchId; }
    public void setMatchId(Long m) { this.matchId = m; }
    public Long getPlayerId() { return playerId; }
    public void setPlayerId(Long p) { this.playerId = p; }

    public Integer getRuns() { return runs; }
    public void setRuns(Integer r) { this.runs = r; }

    public Integer getBalls() { return balls; }
    public void setBalls(Integer b) { this.balls = b; }

    public Integer getFours() { return fours; }
    public void setFours(Integer f) { this.fours = f; }

    public Integer getSixes() { return sixes; }
    public void setSixes(Integer s) { this.sixes = s; }

    public Integer getWickets() { return wickets; }
    public void setWickets(Integer w) { this.wickets = w; }

    public Integer getRunsGiven() { return runsGiven; }
    public void setRunsGiven(Integer r) { this.runsGiven = r; }

    public Double getOversBowled() { return oversBowled; }
    public void setOversBowled(Double o) { this.oversBowled = o; }

    public Boolean getIsOut() { return isOut; }
    public void setIsOut(Boolean out) { this.isOut = out; }
}
