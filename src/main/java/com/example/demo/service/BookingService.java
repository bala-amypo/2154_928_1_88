package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Booking;
import com.example.demo.repository.BookingRepository;

@Service
public class BookingService {

    private final BookingRepository repository;

    public BookingService(BookingRepository repository) {
        this.repository = repository;
    }

    public Booking createBooking(Long facilityId, Long userId) {
        Booking booking = new Booking();
        booking.setFacilityId(facilityId);
        booking.setUserId(userId);
        booking.setStatus("BOOKED");
        return repository.save(booking);
    }

    public Booking cancelBooking(Long bookingId) {
        Booking booking = repository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        booking.setStatus("CANCELLED");
        return repository.save(booking);
    }

    public Booking getById(Long bookingId) {
        return repository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
    }
}
