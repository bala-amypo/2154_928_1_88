package com.example.demo.service;

import com.example.demo.model.Booking;
import com.example.demo.model.BookingLog;
import com.example.demo.repository.BookingLogRepository;
import com.example.demo.repository.BookingRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookingLogService {

    private final BookingLogRepository bookingLogRepository;
    private final BookingRepository bookingRepository;

    public BookingLogService(BookingLogRepository bookingLogRepository, BookingRepository bookingRepository){
        this.bookingLogRepository = bookingLogRepository;
        this.bookingRepository = bookingRepository;
    }

    // Add a log for booking
    public BookingLog addLog(Long bookingId, String message){
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(() -> new RuntimeException("Booking not found"));
        BookingLog log = new BookingLog();
        log.setBooking(booking);
        log.setLogMessage(message);
        return bookingLogRepository.save(log);
    }

    // Get logs for a booking
    public List<BookingLog> getLogsByBooking(Long bookingId){
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(() -> new RuntimeException("Booking not found"));
        return bookingLogRepository.findByBookingOrderByLoggedAtAsc(booking);
    }
}
