package com.example.demo.service;

import com.example.demo.entity.Booking;
import com.example.demo.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Booking createBooking(Long facilityId, Long userId) {
        Booking booking = new Booking();
        booking.setFacilityId(facilityId);
        booking.setUserId(userId);
        booking.setStatus("CONFIRMED");
        booking.setCreatedAt(LocalDateTime.now());
        return bookingRepository.save(booking);
    }

    @Override
    public Optional<Booking> getBooking(Long bookingId) {
        return bookingRepository.findById(bookingId);
    }

    @Override
    public Optional<Booking> cancelBooking(Long bookingId) {
        Optional<Booking> bookingOpt = bookingRepository.findById(bookingId);
        if (bookingOpt.isPresent()) {
            Booking booking = bookingOpt.get();
            booking.setStatus("CANCELLED");
            bookingRepository.save(booking);
            return Optional.of(booking);
        }
        return Optional.empty();
    }
}
