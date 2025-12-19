package com.example.demo.service;

import com.example.demo.entity.Booking;
import java.util.Optional;

public interface BookingService {
    Booking createBooking(Long facilityId, Long userId);
    Optional<Booking> getBooking(Long bookingId);
    Optional<Booking> cancelBooking(Long bookingId);
}
