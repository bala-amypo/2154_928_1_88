package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.entity.BookingLog;
import com.example.demo.service.BookingLogService;

@RestController
@RequestMapping("/logs")
public class BookingLogController {

    private final BookingLogService service;

    public BookingLogController(BookingLogService service) {
        this.service = service;
    }

    @GetMapping("/booking/{bookingId}")
    public List<BookingLog> getLogs(@PathVariable Long bookingId) {
        return service.findByBookingId(bookingId);
    }
}
