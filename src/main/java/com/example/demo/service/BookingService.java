package com.example.demo.service;

import com.example.demo.model.Booking; // ⬅️ FIX
import java.util.List;

public interface BookingService {
    Booking createBooking(Booking booking);
    Booking cancelBooking(Long bookingId);
    Booking getBooking(Long id);
    List<Booking> getAllBookings();
}
