package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.service.BookingLogService;
import com.example.demo.entity.BookingLog;
import com.example.demo.repository.BookingLogRepository;

@Service
public class BookingLogServiceImpl implements BookingLogService {

    private final BookingLogRepository repo;

    public BookingLogServiceImpl(BookingLogRepository repo) {
        this.repo = repo;
    }

    public List<BookingLog> findByBookingId(Long bookingId) {
        return repo.findAll();
    }
}
