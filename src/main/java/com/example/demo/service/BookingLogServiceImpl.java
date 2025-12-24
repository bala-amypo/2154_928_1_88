package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.Booking;
import com.example.demo.model.BookingLog;
import com.example.demo.repository.BookingLogRepository;
import com.example.demo.repository.BookingRepository;
import com.example.demo.service.BookingLogService;

@Service
public class BookingLogServiceImpl implements BookingLogService {

    private final BookingLogRepository bookingLogRepository;
    private final BookingRepository bookingRepository;

    public BookingLogServiceImpl(BookingLogRepository bookingLogRepository,
                                 BookingRepository bookingRepository) {
        this.bookingLogRepository = bookingLogRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    @Transactional // Ensures addLog is executed in a transaction
    public BookingLog addLog(Long bookingId, String message) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new BadRequestException("Booking not found"));

        BookingLog log = new BookingLog();
        log.setBooking(booking);
        log.setLogMessage(message);

        return bookingLogRepository.save(log);
    }

    @Override
    @Transactional(readOnly = true) // Read-only transaction for fetching logs
    public List<BookingLog> getLogsByBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new BadRequestException("Booking not found"));

        return bookingLogRepository.findLogsByBooking(booking);
    }
}
