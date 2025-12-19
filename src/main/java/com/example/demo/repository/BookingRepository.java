package com.example.demo.repository;

import com.example.demo.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepositry extends JpaRepository<Booking, Long> {
    // You can add custom queries here if needed
}
