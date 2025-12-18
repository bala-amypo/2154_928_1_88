package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Booking;
import com.example.demo.service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    @PostMapping
    public Booking save(@RequestBody Booking booking) {
        return service.saveBooking(booking);
    }

    @GetMapping
    public List<Booking> getAll() {
        return service.getAllBookings();
    }
}
