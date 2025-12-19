package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.BookingLog;

public interface BookingLogService {

    BookingLog saveLog(BookingLog log);

    List<BookingLog> findByBookingId(Long bookingId);
}
