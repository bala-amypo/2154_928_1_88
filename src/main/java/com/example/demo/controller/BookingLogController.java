// src/main/java/com/example/demo/controller/BookingLogController.java
package com.example.demo.controller;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.BookingLog;
import com.example.demo.service.BookingLogService;

@RestController
@RequestMapping("/logs")
@Validated   // ✅ REQUIRED for @PathVariable validation
public class BookingLogController {

    private final BookingLogService service;

    public BookingLogController(BookingLogService service) {
        this.service = service;
    }

    @GetMapping("/booking/{bookingId}")
    public List<BookingLog> getLogs(
            @PathVariable("bookingId")
            @NotNull(message = "Booking ID cannot be null")
            @Positive(message = "Booking ID must be greater than 0")
            Long bookingId) {

        return service.findByBookingId(bookingId);
    }
}
