// src/main/java/com/example/demo/repository/BookingLogRepository.java
package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.BookingLog;

public interface BookingLogRepository extends JpaRepository<BookingLog, Long> {

    // 🔥 THIS FIXES YOUR ERROR
    List<BookingLog> findByBookingId(Long bookingId);
}
