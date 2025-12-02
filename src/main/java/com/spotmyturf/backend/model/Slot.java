package com.spotmyturf.backend.model;

import jakarta.persistence.*;

@Entity
public class Slot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long turfId;
    private String startTime;
    private String endTime;
    private String slotType;   // MORNING / NIGHT
    private String date;       // yyyy-MM-dd
    private boolean booked;    // true / false

    public Slot() {}

    public Long getId() { return id; }

    public Long getTurfId() { return turfId; }
    public void setTurfId(Long turfId) { this.turfId = turfId; }

    public String getStartTime() { return startTime; }
    public void setStartTime(String startTime) { this.startTime = startTime; }

    public String getEndTime() { return endTime; }
    public void setEndTime(String endTime) { this.endTime = endTime; }

    public String getSlotType() { return slotType; }
    public void setSlotType(String slotType) { this.slotType = slotType; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public boolean isBooked() { return booked; }
    public void setBooked(boolean booked) { this.booked = booked; }
}
