package com.spotmyturf.backend.service.impl;

import com.spotmyturf.backend.dto.UserDashboardResponse;
import com.spotmyturf.backend.model.Booking;
import com.spotmyturf.backend.model.User;
import com.spotmyturf.backend.repository.BookingRepository;
import com.spotmyturf.backend.repository.UserRepository;
import com.spotmyturf.backend.service.UserDashboardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Service
public class UserDashboardServiceImpl implements UserDashboardService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private BookingRepository bookingRepo;

    @Override
    public UserDashboardResponse getDashboard(Long userId) {

        UserDashboardResponse res = new UserDashboardResponse();

        User user = userRepo.findById(userId).orElse(null);
        if (user == null) return null;

        // user details
        res.setName(user.getName());
        res.setPhone(user.getPhone());
        res.setEmail(user.getEmail());

        // booking list
        List<Booking> bookings = bookingRepo.findByUserId(userId);
        res.setBookingHistory(bookings);

        // total bookings
        res.setTotalBookings(bookings.size());

        // date calculation
        LocalDate today = LocalDate.now();

        // today
        int todayCount = (int) bookings.stream()
                .filter(b -> LocalDate.parse(b.getDate()).equals(today))
                .count();
        res.setTodayBookings(todayCount);

        // upcoming bookings
        int upcomingCount = (int) bookings.stream()
                .filter(b -> LocalDate.parse(b.getDate()).isAfter(today))
                .count();
        res.setUpcomingBookings(upcomingCount);

        // completed bookings
        int completedCount = (int) bookings.stream()
                .filter(b -> LocalDate.parse(b.getDate()).isBefore(today))
                .count();
        res.setCompletedBookings(completedCount);

        // total spent
        double totalSpent = bookings.stream()
                .mapToDouble(Booking::getAmount)
                .sum();
        res.setTotalSpent(totalSpent);

        return res;
    }
}
