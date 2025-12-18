package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.BookingLog;
import com.example.demo.service.BookingLogService;

@RestController
@RequestMapping("/logs")
public class BookingLogController {

    @Autowired
    private BookingLogService bookingLogService;

    @GetMapping("/booking/{bookingId}")
    public List<BookingLog> getLogsByBooking(@PathVariable Long bookingId) {
        return bookingLogService.getLogsByBookingId(bookingId);
    }
}
