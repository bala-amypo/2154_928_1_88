// src/main/java/com/example/demo/controller/BookingController.java
package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Booking;
import com.example.demo.service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    // CREATE BOOKING
    @PostMapping("/{facilityId}/{userId}")
    public Booking createBooking(
            @PathVariable Long facilityId,
            @PathVariable Long userId) {

        return bookingService.createBooking(facilityId, userId);
    }

    // CANCEL BOOKING
    @PutMapping("/cancel/{bookingId}")
    public Booking cancelBooking(@PathVariable Long bookingId) {
        return bookingService.cancelBooking(bookingId);
    }
}
