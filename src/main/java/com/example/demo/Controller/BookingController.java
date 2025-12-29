package com.example.demo.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Booking;
import com.example.demo.service.BookingService;

@RestController
@RequestMapping("/bookings")
@Validated
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/{facilityId}/{userId}")
    public ResponseEntity<Booking> createBooking(
            @PathVariable @NotNull(message = "Facility ID is required") Long facilityId,
            @PathVariable @NotNull(message = "User ID is required") Long userId,
            @Valid @RequestBody Booking booking) {

        return ResponseEntity.ok(
                bookingService.createBooking(facilityId, userId, booking)
        );
    }

    @PutMapping("/cancel/{bookingId}")
    public ResponseEntity<Booking> cancelBooking(
            @PathVariable @NotNull(message = "Booking ID is required") Long bookingId) {

        return ResponseEntity.ok(
                bookingService.cancelBooking(bookingId)
        );
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<Booking> getBooking(
            @PathVariable @NotNull(message = "Booking ID is required") Long bookingId) {

        return ResponseEntity.ok(
                bookingService.getBooking(bookingId)
        );
    }
}