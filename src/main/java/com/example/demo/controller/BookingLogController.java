package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import java.util.List;
import com.example.demo.model.BookingLog;
import com.example.demo.service.BookingLogService;

@RestController
@RequestMapping("/logs")
@Validated
public class BookingLogController {

    private final BookingLogService bookingLogService;
    public BookingLogController(BookingLogService service) { this.bookingLogService = service; }

    @PostMapping("/{bookingId}")
    public ResponseEntity<BookingLog> addLog(@PathVariable Long bookingId, @RequestBody String msg) {
        BookingLog log = bookingLogService.addLog(bookingId, msg);
        return ResponseEntity.ok(log);
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<List<BookingLog>> getLogs(@PathVariable Long bookingId) {
        List<BookingLog> logs = bookingLogService.getLogsByBooking(bookingId);
        return ResponseEntity.ok(logs);
    }
}
