// src/main/java/com/example/demo/service/BookingServiceImpl.java
package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Booking;
import com.example.demo.entity.Facility;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.FacilityRepository;
import com.example.demo.repository.UserRepository;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepo;
    private final FacilityRepository facilityRepo;
    private final UserRepository userRepo;

    public BookingServiceImpl(
            BookingRepository bookingRepo,
            FacilityRepository facilityRepo,
            UserRepository userRepo) {
        this.bookingRepo = bookingRepo;
        this.facilityRepo = facilityRepo;
        this.userRepo = userRepo;
    }

    @Override
    public Booking createBooking(Long facilityId, Long userId) {

        Facility facility = facilityRepo.findById(facilityId)
                .orElseThrow(() -> new ResourceNotFoundException("Facility not found"));

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Booking booking = new Booking();
        booking.setFacility(facility);
        booking.setUser(user);
        booking.setStatus("BOOKED");

        return bookingRepo.save(booking);
    }

    @Override
    public Booking cancelBooking(Long bookingId) {

        Booking booking = bookingRepo.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found"));

        booking.setStatus("CANCELLED");
        return bookingRepo.save(booking);
    }
}
