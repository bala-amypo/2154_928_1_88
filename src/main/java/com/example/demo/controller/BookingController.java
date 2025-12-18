package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Booking;
import com.example.demo.service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    @PostMapping
    public Booking create(@RequestBody Booking booking) {
        return service.save(booking);
    }

    @GetMapping("/{id}")
    public Booking get(@PathVariable Long id) {
        return service.getById(id);
    }
}
