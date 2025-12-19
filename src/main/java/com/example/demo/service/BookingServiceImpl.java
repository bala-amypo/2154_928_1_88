package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Booking;
import com.example.demo.entity.User;
import com.example.demo.entity.Facility;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.FacilityRepository;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepo;
    private final UserRepository userRepo;
    private final FacilityRepository facilityRepo;

    public BookingServiceImpl(BookingRepository bookingRepo, UserRepository userRepo, FacilityRepository facilityRepo) {
        this.bookingRepo = bookingRepo;
        this.userRepo = userRepo;
        this.facilityRepo = facilityRepo;
    }

    @Override
    public Booking createBooking(Long facilityId, Long userId) {
        // Check if User exists
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));

        // Check if Facility exists
        Facility facility = facilityRepo.findById(facilityId)
                .orElseThrow(() -> new ResourceNotFoundException("Facility not found with id " + facilityId));

        // Create Booking
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setFacility(facility);
        booking.setStatus("ACTIVE");

        return bookingRepo.save(booking);
    }

    @Override
    public Booking cancelBooking(Long bookingId) {
        Booking booking = bookingRepo.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id " + bookingId));
        booking.setStatus("CANCELLED");
        return bookingRepo.save(booking);
    }

    @Override
    public Booking getBookingById(Long bookingId) {
        return bookingRepo.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id " + bookingId));
    }
}
