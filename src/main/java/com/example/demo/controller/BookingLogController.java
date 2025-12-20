package com.example.demo.controller;

import com.example.demo.entity.BookingLog;
import com.example.demo.service.BookingLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class BookingLogController {

    private final BookingLogService bookingLogService;

    public BookingLogController(BookingLogService bookingLogService) {
        this.bookingLogService = bookingLogService;
    }

    @GetMapping("/booking/{bookingId}")
    public List<BookingLog> getLogsByBooking(@PathVariable Long bookingId) {
        return bookingLogService.getLogsByBookingId(bookingId);
    }
}
