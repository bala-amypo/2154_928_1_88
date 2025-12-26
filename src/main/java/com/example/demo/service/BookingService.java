package com.example.demo.service;

import com.example.demo.entity.Booking;
import com.example.demo.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository repo;

    public BookingService(BookingRepository repo){ this.repo = repo; }

    public Booking save(Booking b){ return repo.save(b); }
    public List<Booking> all(){ return repo.findAll(); }
}
