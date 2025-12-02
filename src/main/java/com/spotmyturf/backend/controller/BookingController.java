package com.spotmyturf.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.spotmyturf.backend.dto.BookingRequest;
import com.spotmyturf.backend.model.Booking;
import com.spotmyturf.backend.service.BookingService;

import java.util.List;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    private BookingService service;

    @PostMapping("/create")
    public String create(@RequestBody BookingRequest req) {
        return service.createBooking(req);
    }

    @GetMapping("/user/{userId}")
    public List<Booking> userBookings(@PathVariable Long userId) {
        return service.getUserBookings(userId);
    }

    @GetMapping("/turf/{turfId}")
    public List<Booking> turfBookings(@PathVariable Long turfId) {
        return service.getTurfBookings(turfId);
    }
}
