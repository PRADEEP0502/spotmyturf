package com.spotmyturf.backend.dto;

import java.util.List;

public class OwnerDashboardResponse {

    private int totalTurfs;
    private int totalBookings;
    private int todayBookings;
    private int monthlyBookings;
    private double totalIncome;
    private List<?> turfs;

    public int getTotalTurfs() { return totalTurfs; }
    public void setTotalTurfs(int totalTurfs) { this.totalTurfs = totalTurfs; }

    public int getTotalBookings() { return totalBookings; }
    public void setTotalBookings(int totalBookings) { this.totalBookings = totalBookings; }

    public int getTodayBookings() { return todayBookings; }
    public void setTodayBookings(int todayBookings) { this.todayBookings = todayBookings; }

    public int getMonthlyBookings() { return monthlyBookings; }
    public void setMonthlyBookings(int monthlyBookings) { this.monthlyBookings = monthlyBookings; }

    public double getTotalIncome() { return totalIncome; }
    public void setTotalIncome(double totalIncome) { this.totalIncome = totalIncome; }

    public List<?> getTurfs() { return turfs; }
    public void setTurfs(List<?> turfs) { this.turfs = turfs; }
}
