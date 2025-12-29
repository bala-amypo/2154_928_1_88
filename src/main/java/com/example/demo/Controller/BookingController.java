package com.example.demo.controller;

import com.example.demo.model.Booking;
import com.example.demo.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }

    @PostMapping("/create/{facilityId}/{userId}")
    public ResponseEntity<Booking> createBooking(@PathVariable Long facilityId,
                                                 @PathVariable Long userId,
                                                 @RequestBody Booking booking){
        Booking savedBooking = bookingService.createBooking(facilityId, userId, booking);
        return ResponseEntity.ok(savedBooking);
    }

    @PostMapping("/cancel/{bookingId}")
    public ResponseEntity<Booking> cancelBooking(@PathVariable Long bookingId){
        Booking cancelled = bookingService.cancelBooking(bookingId);
        return ResponseEntity.ok(cancelled);
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<Booking> getBooking(@PathVariable Long bookingId){
        return ResponseEntity.ok(bookingService.getBooking(bookingId));
    }
}
