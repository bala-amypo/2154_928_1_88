// File: BookingServiceImpl.java
package com.example.demo.service;

import com.example.demo.entity.Booking;
import com.example.demo.repository.BookingRepository;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Booking createBooking(Long facilityId, Long userId) {
        // existing logic
        return null;
    }

    @Override
    public Booking cancelBooking(Long bookingId) {
        // existing logic
        return null;
    }

    // ✅ ADD THIS METHOD
    @Override
    public Booking getBookingById(Long bookingId) {
        return bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found with id " + bookingId));
    }
}

