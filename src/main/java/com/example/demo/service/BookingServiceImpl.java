// File: src/main/java/com/example/demo/service/BookingServiceImpl.java
package com.example.demo.service;

import com.example.demo.entity.Booking;
import com.example.demo.entity.Facility;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.FacilityRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final FacilityRepository facilityRepository;

    public BookingServiceImpl(BookingRepository bookingRepository,
                              UserRepository userRepository,
                              FacilityRepository facilityRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.facilityRepository = facilityRepository;
    }

    public Booking createBooking(Long facilityId, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));

        Facility facility = facilityRepository.findById(facilityId)
                .orElseThrow(() -> new ResourceNotFoundException("Facility not found with id " + facilityId));

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setFacility(facility);
        booking.setStatus("ACTIVE");

        return bookingRepository.save(booking);
    }

    public Booking cancelBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id " + bookingId));
        booking.setStatus("CANCELLED");
        return bookingRepository.save(booking);
    }
}
