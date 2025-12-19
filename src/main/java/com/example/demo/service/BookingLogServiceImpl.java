// src/main/java/com/example/demo/service/impl/BookingLogServiceImpl.java
package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.BookingLog;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.BookingLogRepository;
import com.example.demo.service.BookingLogService;

@Service
public class BookingLogServiceImpl implements BookingLogService {

    private final BookingLogRepository repository;

    public BookingLogServiceImpl(BookingLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<BookingLog> findByBookingId(Long bookingId) {

        List<BookingLog> logs = repository.findByBookingId(bookingId);

        if (logs.isEmpty()) {
            throw new ResourceNotFoundException(
                "No booking logs found for booking id " + bookingId
            );
        }

        return logs;
    }
}
