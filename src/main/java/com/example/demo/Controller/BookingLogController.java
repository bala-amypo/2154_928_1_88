package com.example.demo.controller;

import com.example.demo.model.BookingLog;
import com.example.demo.service.BookingLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Booking Logs")
@RestController
@RequestMapping("/logs")
public class BookingLogController {

    private final BookingLogService bookingLogService;

    public BookingLogController(BookingLogService bookingLogService) {
        this.bookingLogService = bookingLogService;
    }

    @ApiOperation("Get logs by booking ID")
    @GetMapping("/booking/{bookingId}")
    public List<BookingLog> getLogsByBooking(@PathVariable Long bookingId) {
        return bookingLogService.getLogsByBooking(bookingId);
    }
}
