package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Booking;
import com.example.demo.model.Facility;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    // ✅ HQL / JPQL query to detect overlapping bookings
    @Query("""
        SELECT b FROM Booking b
        WHERE b.facility = :facility
        AND b.status = 'CONFIRMED'
        AND b.startTime < :endTime
        AND b.endTime > :startTime
    """)
    List<Booking> findConflictingBookings(
            @Param("facility") Facility facility,
            @Param("startTime") LocalDateTime startTime,
            @Param("endTime") LocalDateTime endTime
    );
}
