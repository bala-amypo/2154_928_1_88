package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.model.Booking;
import com.example.demo.model.Facility;
import com.example.demo.model.User;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.FacilityRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.BookingService;
import com.example.demo.service.BookingLogService;
import com.example.demo.exception.ConflictException;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepo;
    private final FacilityRepository facilityRepo;
    private final UserRepository userRepo;
    private final BookingLogService logService;

    public BookingServiceImpl(BookingRepository bookingRepo,
                              FacilityRepository facilityRepo,
                              UserRepository userRepo,
                              BookingLogService logService){
        this.bookingRepo = bookingRepo;
        this.facilityRepo = facilityRepo;
        this.userRepo = userRepo;
        this.logService = logService;
    }

    @Override
    public Booking createBooking(Long userId, Long facilityId, Booking b){
        Facility f = facilityRepo.findById(facilityId).orElseThrow();
        User u = userRepo.findById(userId).orElseThrow();

        List<Booking> conflicts = bookingRepo.findByFacilityAndStartTimeLessThanAndEndTimeGreaterThan(
                f, b.getEndTime(), b.getStartTime());

        if(!conflicts.isEmpty()) throw new ConflictException("Booking conflict");

        b.setFacility(f);
        b.setUser(u);
        b.setStatus(Booking.STATUS_CONFIRMED);

        Booking saved = bookingRepo.save(b);
        logService.addLog(saved.getId(), "Booking created");
        return saved;
    }

    @Override
    public Booking cancelBooking(Long bookingId){
        Booking b = bookingRepo.findById(bookingId).orElseThrow();
        b.setStatus(Booking.STATUS_CANCELLED);
        Booking saved = bookingRepo.save(b);
        logService.addLog(saved.getId(), "Booking cancelled");
        return saved;
    }

    @Override
    public Booking getBooking(Long bookingId){
        return bookingRepo.findById(bookingId).orElseThrow();
    }
}
