package com.example.demo.controller;

import com.example.demo.entity.Booking;
import com.example.demo.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService service;

    public BookingController(BookingService service){ this.service = service; }

    @PostMapping
    public Booking save(@RequestBody Booking b){ return service.save(b); }

    @GetMapping
    public List<Booking> all(){ return service.all(); }
}
