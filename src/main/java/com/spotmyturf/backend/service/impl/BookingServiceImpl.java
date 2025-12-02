package com.spotmyturf.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spotmyturf.backend.dto.BookingRequest;
import com.spotmyturf.backend.model.Booking;
import com.spotmyturf.backend.model.Slot;
import com.spotmyturf.backend.repository.BookingRepository;
import com.spotmyturf.backend.repository.SlotRepository;
import com.spotmyturf.backend.service.BookingService;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository repo;

    @Autowired
    private SlotRepository slotRepo;

    @Override
    public String createBooking(BookingRequest req) {

        Slot s = slotRepo.findById(req.getSlotId()).orElse(null);
        if (s == null) return "Slot not found";

        if (s.isBooked()) return "Slot already booked";

        s.setBooked(true);
        slotRepo.save(s);

        Booking b = new Booking();
        b.setUserId(req.getUserId());
        b.setTurfId(req.getTurfId());
        b.setSlotId(req.getSlotId());
        b.setDate(req.getDate());
        b.setAmount(req.getAmount());
        b.setStatus("BOOKED");

        b.setStartTime(s.getStartTime());
        b.setEndTime(s.getEndTime());

        repo.save(b);

        return "Booking Successful";
    }

    @Override
    public List<Booking> getUserBookings(Long userId) {
        return repo.findByUserId(userId);
    }

    @Override
    public List<Booking> getTurfBookings(Long turfId) {
        return repo.findByTurfId(turfId);
    }
}
