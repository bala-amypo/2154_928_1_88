package com.example.demo.service;

import com.example.demo.entity.Booking;

public interface BookingService {
    Booking save(Booking booking);
    Booking getById(Long id);
}
