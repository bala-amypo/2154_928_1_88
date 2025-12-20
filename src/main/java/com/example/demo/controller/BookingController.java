package com.example.demo.controller;

import com.example.demo.entity.Booking;
import com.example.demo.service.BookingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/{facilityId}/{userId}")
    public Booking createBooking(
            @PathVariable Long facilityId,
            @PathVariable Long userId) {
        return bookingService.createBooking(facilityId, userId);
    }

    @GetMapping("/{bookingId}")
    public Booking getBooking(@PathVariable Long bookingId) {
        return bookingService.getBookingById(bookingId);
    }

    @PutMapping("/cancel/{bookingId}")
    public Booking cancelBooking(@PathVariable Long bookingId) {
        return bookingService.cancelBooking(bookingId);
    }
}
