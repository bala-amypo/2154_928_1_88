package com.example.demo.service;

import com.example.demo.model.Booking; // ⬅️ FIX
import com.example.demo.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepository repo;

    @Override
    public Booking createBooking(Booking booking) {
        booking.setStatus("CONFIRMED"); // ⬅️ match your model field
        return repo.save(booking);
    }

    @Override
    public Booking cancelBooking(Long id) {
        Booking booking = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found"));

        booking.setStatus("CANCELLED");
        return repo.save(booking);
    }

    @Override
    public Booking getBooking(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found"));
    }

    @Override
    public List<Booking> getAllBookings() {
        return repo.findAll();
    }
}
