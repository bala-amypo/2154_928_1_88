package com.example.demo.controller;

import com.example.demo.model.Booking;
import com.example.demo.service.BookingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Bookings")
@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @ApiOperation("Create a new booking")
    @PostMapping("/{facilityId}/{userId}")
    public Booking createBooking(@PathVariable Long facilityId,
                                 @PathVariable Long userId,
                                 @RequestBody Booking booking) {
        return bookingService.createBooking(facilityId, userId, booking);
    }

    @ApiOperation("Cancel a booking")
    @PutMapping("/cancel/{bookingId}")
    public Booking cancelBooking(@PathVariable Long bookingId) {
        return bookingService.cancelBooking(bookingId);
    }

    @ApiOperation("Get a booking by ID")
    @GetMapping("/{bookingId}")
    public Booking getBooking(@PathVariable Long bookingId) {
        return bookingService.getBooking(bookingId);
    }
}
