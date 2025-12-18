package com.example.demo.service;

import com.example.demo.entity.BookingLog;
import java.util.List;

public interface BookingLogService {
    List<BookingLog> findByBookingId(Long bookingId);
}
