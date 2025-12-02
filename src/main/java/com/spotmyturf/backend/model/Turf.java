package com.spotmyturf.backend.model;

import jakarta.persistence.*;

@Entity
public class Turf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String turfName;
    private String location;
    private String sportType;
    private String openTime;
    private String closeTime;

    private Long ownerId;

    private String status = "PENDING"; 
    private boolean active = false;

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
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
