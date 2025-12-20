package com.example.demo.controller;

import java.util.List;

import jakarta.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.BookingLog;
import com.example.demo.service.BookingLogService;

@RestController
@RequestMapping("/logs")
@Validated
public class BookingLogController {

    private final BookingLogService bookingLogService;

    public BookingLogController(BookingLogService bookingLogService) {
        this.bookingLogService = bookingLogService;
    }

    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<List<BookingLog>> getLogs(
            @PathVariable @NotNull(message = "Booking ID is required") Long bookingId) {

        return ResponseEntity.ok(
                bookingLogService.getLogsByBooking(bookingId)
        );
    }
}
