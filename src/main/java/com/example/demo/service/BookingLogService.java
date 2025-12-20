package com.example.demo.service;

import java.util.List;
import com.example.demo.model.BookingLog;

public interface BookingLogService {
    BookingLog saveLog(BookingLog log);
    List<BookingLog> getAllLogs();
}
