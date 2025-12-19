// src/main/java/com/example/demo/repository/BookingRepository.java
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
