package com.example.demo.controller;

import com.example.demo.entity.Booking;
import com.example.demo.repository.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingRepo bookingRepo;

    // POST /bookings/{facilityId}/{userId} → create a booking
    @PostMapping("/{facilityId}/{userId}")
    public ResponseEntity<Booking> createBooking(
            @PathVariable Long facilityId,
            @PathVariable Long userId) {

        Booking booking = new Booking();
        booking.setFacilityId(facilityId);
        booking.setUserId(userId);
        booking.setStatus("CONFIRMED");
        booking.setCreatedAt(LocalDateTime.now());

        Booking savedBooking = bookingRepo.save(booking);
        return ResponseEntity.ok(savedBooking);
    }

    // GET /bookings/{bookingId} → get booking details
    @GetMapping("/{bookingId}")
    public ResponseEntity<Booking> getBooking(@PathVariable Long bookingId) {
        Optional<Booking> booking = bookingRepo.findById(bookingId);
        return booking.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // PUT /bookings/cancel/{bookingId} → cancel a booking
    @PutMapping("/cancel/{bookingId}")
    public ResponseEntity<Booking> cancelBooking(@PathVariable Long bookingId) {
        Optional<Booking> optionalBooking = bookingRepo.findById(bookingId);

        if (optionalBooking.isPresent()) {
            Booking booking = optionalBooking.get();
            booking.setStatus("CANCELLED");
            bookingRepo.save(booking);
            return ResponseEntity.ok(booking);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
