package com.spotmyturf.backend.dto;

import java.util.List;

public class UserDashboardResponse {

    private String name;
    private String phone;
    private String email;

    private int totalBookings;
    private int upcomingBookings;
    private int completedBookings;
    private int todayBookings;

    private double totalSpent;

    private List<?> bookingHistory;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getTotalBookings() { return totalBookings; }
    public void setTotalBookings(int totalBookings) { this.totalBookings = totalBookings; }

    public int getUpcomingBookings() { return upcomingBookings; }
    public void setUpcomingBookings(int upcomingBookings) { this.upcomingBookings = upcomingBookings; }

    public int getCompletedBookings() { return completedBookings; }
    public void setCompletedBookings(int completedBookings) { this.completedBookings = completedBookings; }

    public int getTodayBookings() { return todayBookings; }
    public void setTodayBookings(int todayBookings) { this.todayBookings = todayBookings; }

    public double getTotalSpent() { return totalSpent; }
    public void setTotalSpent(double totalSpent) { this.totalSpent = totalSpent; }

    public List<?> getBookingHistory() { return bookingHistory; }
    public void setBookingHistory(List<?> bookingHistory) { this.bookingHistory = bookingHistory; }
}
