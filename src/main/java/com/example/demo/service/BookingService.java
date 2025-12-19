// File: src/main/java/com/example/demo/service/BookingService.java
package com.example.demo.service;

import com.example.demo.entity.Booking;

public interface BookingService {
    Booking createBooking(Long facilityId, Long userId);
    Booking cancelBooking(Long bookingId);
    
}
