package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.entity.Booking;
import com.example.demo.service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    // Create Booking
    @PostMapping("/{facilityId}/{userId}")
    public Booking createBooking(@PathVariable Long facilityId, @PathVariable Long userId) {
        return bookingService.createBooking(facilityId, userId);
    }

    // Cancel Booking
    @PutMapping("/cancel/{bookingId}")
    public Booking cancelBooking(@PathVariable Long bookingId) {
        return bookingService.cancelBooking(bookingId);
    }

    // Get Booking by Id
    @GetMapping("/{bookingId}")
    public Booking getBooking(@PathVariable Long bookingId) {
        return bookingService.getBookingById(bookingId);
    }
}
