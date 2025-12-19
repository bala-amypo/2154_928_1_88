// src/main/java/com/example/demo/service/BookingLogService.java
package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.BookingLog;

public interface BookingLogService {

    List<BookingLog> findByBookingId(Long bookingId);
}
