package com.spotmyturf.backend.dto;

public class TurfRequest {

    private String turfName;
    private String location;
    private String sportType;
    private String openTime;
    private String closeTime;
    private Long ownerId;

    public String getTurfName() { return turfName; }
    public String getLocation() { return location; }
    public String getSportType() { return sportType; }
    public String getOpenTime() { return openTime; }
    public String getCloseTime() { return closeTime; }
    public Long getOwnerId() { return ownerId; }

    public void setTurfName(String turfName) { this.turfName = turfName; }
    public void setLocation(String location) { this.location = location; }
    public void setSportType(String sportType) { this.sportType = sportType; }
    public void setOpenTime(String openTime) { this.openTime = openTime; }
    public void setCloseTime(String closeTime) { this.closeTime = closeTime; }
    public void setOwnerId(Long ownerId) { this.ownerId = ownerId; }
}
