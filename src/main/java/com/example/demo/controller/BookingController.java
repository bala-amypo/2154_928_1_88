package com.example.demo.controller;

import com.example.demo.entity.Booking;
import com.example.demo.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // POST /bookings/{facilityId}/{userId} → create booking
    @PostMapping("/{facilityId}/{userId}")
    public ResponseEntity<Booking> createBooking(
            @PathVariable Long facilityId,
            @PathVariable Long userId) {
        Booking booking = bookingService.createBooking(facilityId, userId);
        return ResponseEntity.ok(booking);
    }

    // GET /bookings/{bookingId} → get booking details
    @GetMapping("/{bookingId}")
    public ResponseEntity<Booking> getBooking(@PathVariable Long bookingId) {
        return bookingService.getBooking(bookingId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // PUT /bookings/cancel/{bookingId} → cancel booking
    @PutMapping("/cancel/{bookingId}")
    public ResponseEntity<Booking> cancelBooking(@PathVariable Long bookingId) {
        return bookingService.cancelBooking(bookingId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
