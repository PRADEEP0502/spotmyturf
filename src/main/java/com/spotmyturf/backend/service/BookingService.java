package com.spotmyturf.backend.service;

import java.util.List;
import com.spotmyturf.backend.dto.BookingRequest;
import com.spotmyturf.backend.model.Booking;

public interface BookingService {

    String createBooking(BookingRequest req);

    List<Booking> getUserBookings(Long userId);

    List<Booking> getTurfBookings(Long turfId);
}
