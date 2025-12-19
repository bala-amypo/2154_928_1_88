package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.BookingLog;
import com.example.demo.repository.BookingLogRepository;

@Service
public class BookingLogServiceImpl implements BookingLogService {

    private final BookingLogRepository repository;

    public BookingLogServiceImpl(BookingLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public BookingLog saveLog(BookingLog log) {
        return repository.save(log);
    }

    @Override
    public List<BookingLog> findByBookingId(Long bookingId) {
        return repository.findByBookingId(bookingId);
    }
}
