package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.service.BookingService;
import com.example.demo.entity.Booking;
import com.example.demo.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository repo;

    public BookingServiceImpl(BookingRepository repo) {
        this.repo = repo;
    }

    public Booking save(Booking booking) {
        return repo.save(booking);
    }

    public Booking getById(Long id) {
        return repo.findById(id).orElse(null);
    }
}
