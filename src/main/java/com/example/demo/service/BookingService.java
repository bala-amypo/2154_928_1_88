package com.example.demo.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entity.Booking;
import com.example.demo.repository.BookingRepository;

@Service
public class BookingService {

    private final BookingRepository repository;

    public BookingService(BookingRepository repository) {
        this.repository = repository;
    }

    // POST /bookings/{facilityId}/{userId}
    public Booking createBooking(Long facilityId, Long userId) {
        Booking booking = new Booking();
        booking.setFacilityId(facilityId);
        booking.setUserId(userId);
        booking.setStatus("BOOKED");
        return repository.save(booking);
    }

    // PUT /bookings/cancel/{bookingId}
    public Booking cancelBooking(Long bookingId) {
        Booking booking = repository.findById(bookingId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Booking not found with id " + bookingId
                ));

        booking.setStatus("CANCELLED");
        return repository.save(booking);
    }

    // GET /bookings/{bookingId}
    public Booking getById(Long bookingId) {
        return repository.findById(bookingId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Booking not found with id " + bookingId
                ));
    }
}
