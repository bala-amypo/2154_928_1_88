package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Booking;
import com.example.demo.model.BookingLog;

public interface BookingLogRepository extends JpaRepository<BookingLog, Long> {

    // Using HQL instead of derived method
    @Query("SELECT bl FROM BookingLog bl WHERE bl.booking = :booking ORDER BY bl.loggedAt ASC")
    List<BookingLog> findLogsByBooking(@Param("booking") Booking booking);
}
