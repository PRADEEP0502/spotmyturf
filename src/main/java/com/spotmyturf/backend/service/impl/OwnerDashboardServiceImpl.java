package com.spotmyturf.backend.service.impl;

import com.spotmyturf.backend.dto.OwnerDashboardResponse;
import com.spotmyturf.backend.model.Booking;
import com.spotmyturf.backend.model.Turf;
import com.spotmyturf.backend.repository.BookingRepository;
import com.spotmyturf.backend.repository.TurfRepository;
import com.spotmyturf.backend.service.OwnerDashboardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Service
public class OwnerDashboardServiceImpl implements OwnerDashboardService {

    @Autowired
    private TurfRepository turfRepo;

    @Autowired
    private BookingRepository bookingRepo;

    @Override
    public OwnerDashboardResponse getDashboard(Long ownerId) {

        OwnerDashboardResponse res = new OwnerDashboardResponse();

        // Get turfs by owner
        List<Turf> turfs = turfRepo.findByOwnerId(ownerId);
        res.setTurfs(turfs);
        res.setTotalTurfs(turfs.size());

        // All bookings for owner
        List<Booking> allBookings = bookingRepo.findAll();
        allBookings.removeIf(b -> turfs.stream().noneMatch(t -> t.getId().equals(b.getTurfId())));
        res.setTotalBookings(allBookings.size());

        // Today bookings
        LocalDate today = LocalDate.now();
        int todayCount = (int) allBookings.stream()
                .filter(b -> b.getDate().equals(today))
                .count();
        res.setTodayBookings(todayCount);

        // Monthly bookings
        YearMonth currentMonth = YearMonth.now();
int monthCount = (int) allBookings.stream()
        .filter(b -> YearMonth.from(LocalDate.parse(b.getDate())).equals(currentMonth))
        .count();
res.setMonthlyBookings(monthCount);

        // Total income = sum of all booking amounts
        double totalIncome = allBookings.stream()
                .mapToDouble(Booking::getAmount)
                .sum();
        res.setTotalIncome(totalIncome);

        return res;
    }
}
