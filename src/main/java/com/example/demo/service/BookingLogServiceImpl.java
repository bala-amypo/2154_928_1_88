package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.model.BookingLog;
import com.example.demo.model.Booking;
import com.example.demo.repository.BookingLogRepository;
import com.example.demo.repository.BookingRepository;
import com.example.demo.service.BookingLogService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingLogServiceImpl implements BookingLogService {

    private final BookingLogRepository logRepo;
    private final BookingRepository bookingRepo;

    public BookingLogServiceImpl(BookingLogRepository logRepo, BookingRepository bookingRepo){
        this.logRepo = logRepo;
        this.bookingRepo = bookingRepo;
    }

    @Override
    public BookingLog addLog(Long bookingId, String msg){
        Booking b = bookingRepo.findById(bookingId).orElseThrow();
        BookingLog log = new BookingLog();
        log.setBooking(b);
        log.setLogMessage(msg);
        log.setLoggedAt(LocalDateTime.now());
        return logRepo.save(log);
    }

    @Override
    public List<BookingLog> getLogsByBooking(Long bookingId){
        Booking b = bookingRepo.findById(bookingId).orElseThrow();
        return logRepo.findByBookingOrderByLoggedAtAsc(b);
    }
}
