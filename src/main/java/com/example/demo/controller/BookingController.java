package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Booking;
import com.example.demo.service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    // POST /bookings/{facilityId}/{userId}
    @PostMapping("/{facilityId}/{userId}")
    public Booking createBooking(
            @PathVariable Long facilityId,
            @PathVariable Long userId) {
        return service.createBooking(facilityId, userId);
    }

    // PUT /bookings/cancel/{bookingId}
    @PutMapping("/cancel/{bookingId}")
    public Booking cancelBooking(
            @PathVariable Long bookingId) {
        return service.cancelBooking(bookingId);
    }

    // GET /bookings/{bookingId}
    @GetMapping("/{bookingId}")
    public Booking getBooking(
            @PathVariable Long bookingId) {
        return service.getById(bookingId);
    }
}
