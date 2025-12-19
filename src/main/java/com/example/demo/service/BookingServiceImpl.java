// File: src/main/java/com/example/demo/service/BookingServiceImpl.java
package com.example.demo.service;

import com.example.demo.entity.Booking;
import com.example.demo.entity.User;
import com.example.demo.entity.Facility;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.BookingRepo;
import com.example.demo.repository.UserRepo;
import com.example.demo.repository.FacilityRepo;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepo bookingRepo;
    private final UserRepo userRepo;
    private final FacilityRepo facilityRepo;

    public BookingServiceImpl(BookingRepo bookingRepo, UserRepo userRepo, FacilityRepo facilityRepo) {
        this.bookingRepo = bookingRepo;
        this.userRepo = userRepo;
        this.facilityRepo = facilityRepo;
    }

    @Override
    public Booking createBooking(Long facilityId, Long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
        Facility facility = facilityRepo.findById(facilityId)
                .orElseThrow(() -> new ResourceNotFoundException("Facility not found with id " + facilityId));

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
}
