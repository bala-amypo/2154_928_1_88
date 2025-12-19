// src/main/java/com/example/demo/service/BookingLogService.java
package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.BookingLog;

public interface BookingLogService {

    /**
     * Get all booking logs for a given booking ID
     *
     * @param bookingId booking ID (must be positive)
     * @return list of booking logs
     * @throws ResourceNotFoundException if no logs are found
     */
    List<BookingLog> findByBookingId(Long bookingId);
}
