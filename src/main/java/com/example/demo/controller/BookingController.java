package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import java.util.List;
import com.example.demo.model.Booking;
import com.example.demo.service.BookingService;

@RestController
@RequestMapping("/bookings")
@Validated
public class BookingController {

    private final BookingService bookingService;
    public BookingController(BookingService service) { this.bookingService = service; }

    @PostMapping("/{userId}/{facilityId}")
    public ResponseEntity<Booking> createBooking(@PathVariable Long userId, @PathVariable Long facilityId, @RequestBody Booking b) {
        Booking saved = bookingService.createBooking(userId, facilityId, b);
        return ResponseEntity.ok(saved);
    }

    @PostMapping("/cancel/{bookingId}")
    public ResponseEntity<Booking> cancelBooking(@PathVariable Long bookingId) {
        Booking cancelled = bookingService.cancelBooking(bookingId);
        return ResponseEntity.ok(cancelled);
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<Booking> getBooking(@PathVariable Long bookingId) {
        return ResponseEntity.ok(bookingService.getBooking(bookingId));
    }
}
