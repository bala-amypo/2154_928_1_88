package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.model.BookingLog;
import com.example.demo.repository.BookingLogRepository;
import com.example.demo.service.BookingLogService;

@Service
public class BookingLogServiceImpl implements BookingLogService {

    private final BookingLogRepository repo;

    public BookingLogServiceImpl(BookingLogRepository repo) {
        this.repo = repo;
    }

    public BookingLog saveLog(BookingLog log) {
        return repo.save(log);
    }

    public List<BookingLog> getAllLogs() {
        return repo.findAll();
    }
}
