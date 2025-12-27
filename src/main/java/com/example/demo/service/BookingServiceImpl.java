package com.example.demo.service.impl;

import com.example.demo.exception.ConflictException;
import com.example.demo.model.*;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.FacilityRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.BookingService;
import com.example.demo.service.BookingLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    
    private final BookingRepository bookingRepository;
    private final FacilityRepository facilityRepository;
    private final UserRepository userRepository;
    private final BookingLogService bookingLogService;
    
    @Override
    public Booking createBooking(Long userId, Long facilityId, Booking booking) {
        Facility facility = facilityRepository.findById(facilityId)
            .orElseThrow(() -> new RuntimeException("Facility not found"));
        
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
        
        // Check for conflicts
        List<Booking> conflicts = bookingRepository.findByFacilityAndStartTimeLessThanAndEndTimeGreaterThan(
            facility, booking.getEndTime(), booking.getStartTime());
        
        if (!conflicts.isEmpty()) {
            throw new ConflictException("Booking conflicts with existing booking");
        }
        
        booking.setFacility(facility);
        booking.setUser(user);
        booking.setStatus(Booking.STATUS_CONFIRMED);
        
        Booking saved = bookingRepository.save(booking);
        bookingLogService.addLog(saved.getId(), "Booking created");
        
        return saved;
    }
    
    @Override
    public Booking cancelBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
            .orElseThrow(() -> new RuntimeException("Booking not found"));
        
        booking.setStatus(Booking.STATUS_CANCELLED);
        Booking cancelled = bookingRepository.save(booking);
        bookingLogService.addLog(bookingId, "Booking cancelled");
        
        return cancelled;
    }
    
    @Override
    public Booking getBooking(Long bookingId) {
        return bookingRepository.findById(bookingId)
            .orElseThrow(() -> new RuntimeException("Booking not found"));
    }
}