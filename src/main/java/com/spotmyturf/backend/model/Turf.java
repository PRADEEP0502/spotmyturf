package com.spotmyturf.backend.model;

import jakarta.persistence.*;

@Entity
public class Turf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String turfName;
    private String location;
    private String sportType; // CRICKET / FOOTBALL
    private String openTime;
    private String closeTime;

    private Long ownerId; // Which owner created this turf

    public Turf() {}

    // Getters and Setters
    public Long getId() { return id; }

    public String getTurfName() { return turfName; }
    public void setTurfName(String turfName) { this.turfName = turfName; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getSportType() { return sportType; }
    public void setSportType(String sportType) { this.sportType = sportType; }

    public String getOpenTime() { return openTime; }
    public void setOpenTime(String openTime) { this.openTime = openTime; }

    public String getCloseTime() { return closeTime; }
    public void setCloseTime(String closeTime) { this.closeTime = closeTime; }

    public Long getOwnerId() { return ownerId; }
    public void setOwnerId(Long ownerId) { this.ownerId = ownerId; }
}
