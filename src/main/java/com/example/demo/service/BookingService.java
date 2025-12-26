package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Booking;

public interface BookingService {
    Booking save(Booking booking);
    List<Booking> getAllBookings();
    Booking cancelBooking(Long id);
}
