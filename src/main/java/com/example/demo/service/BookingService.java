package com.example.demo.service;

import com.example.demo.entity.Booking;
import java.util.List;

public interface BookingService {

    Booking createBooking(Long facilityId, Long userId);

    Booking cancelBooking(Long bookingId);

    Booking getBookingById(Long bookingId);
}
