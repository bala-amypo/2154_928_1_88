package com.example.demo.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.BookingLog;
import com.example.demo.service.BookingLogService;

@RestController
@RequestMapping("/logs")
public class BookingLogController {

    private final BookingLogService service;

    public BookingLogController(BookingLogService service) {
        this.service = service;
    }

    // ✅ GET logs by booking id
    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<List<BookingLog>> getLogs(@PathVariable Long bookingId) {
        return ResponseEntity.ok(service.findByBookingId(bookingId));
    }

    // ✅ POST log with validation
    @PostMapping
    public ResponseEntity<BookingLog> createLog(
            @Valid @RequestBody BookingLog log) {
        return ResponseEntity.ok(service.saveLog(log));
    }
}
