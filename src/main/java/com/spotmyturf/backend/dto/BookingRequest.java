package com.spotmyturf.backend.dto;

public class BookingRequest {

    private Long userId;
    private Long turfId;
    private Long slotId;
    private String date;
    private double amount;

    public Long getUserId() { return userId; }
    public Long getTurfId() { return turfId; }
    public Long getSlotId() { return slotId; }
    public String getDate() { return date; }
    public double getAmount() { return amount; }

    public void setUserId(Long userId) { this.userId = userId; }
    public void setTurfId(Long turfId) { this.turfId = turfId; }
    public void setSlotId(Long slotId) { this.slotId = slotId; }
    public void setDate(String date) { this.date = date; }
    public void setAmount(double amount) { this.amount = amount; }
}
