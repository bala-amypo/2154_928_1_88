package com.example.demo.service;

import com.example.demo.exception.ConflictException;
import com.example.demo.model.Booking;
import com.example.demo.model.Facility;
import com.example.demo.model.User;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.FacilityRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final FacilityRepository facilityRepository;
    private final UserRepository userRepository;
    private final BookingLogService bookingLogService;

    public BookingService(BookingRepository bookingRepository,
                          FacilityRepository facilityRepository,
                          UserRepository userRepository,
                          BookingLogService bookingLogService){
        this.bookingRepository = bookingRepository;
        this.facilityRepository = facilityRepository;
        this.userRepository = userRepository;
        this.bookingLogService = bookingLogService;
    }

    // Create a new booking
    public Booking createBooking(Long facilityId, Long userId, Booking booking){
        Facility facility = facilityRepository.findById(facilityId).orElseThrow(() -> new RuntimeException("Facility not found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        // Check for time conflicts
        List<Booking> conflicts = bookingRepository.findByFacilityAndStartTimeLessThanAndEndTimeGreaterThan(
                facility, booking.getEndTime(), booking.getStartTime());

        if(!conflicts.isEmpty()){
            throw new ConflictException("Booking time conflicts with existing bookings");
        }

        booking.setFacility(facility);
        booking.setUser(user);
        booking.setStatus("CONFIRMED");

        Booking savedBooking = bookingRepository.save(booking);
        bookingLogService.addLog(savedBooking.getId(), "Booking created");
        return savedBooking;
    }

    // Cancel a booking
    public Booking cancelBooking(Long bookingId){
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(() -> new RuntimeException("Booking not found"));
        booking.setStatus("CANCELLED");
        Booking cancelled = bookingRepository.save(booking);
        bookingLogService.addLog(cancelled.getId(), "Booking cancelled");
        return cancelled;
    }

    // Get booking by ID
    public Booking getBooking(Long bookingId){
        return bookingRepository.findById(bookingId).orElseThrow(() -> new RuntimeException("Booking not found"));
    }
}
