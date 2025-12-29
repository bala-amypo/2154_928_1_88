package com.example.demo.repository;

import com.example.demo.model.Booking;
import com.example.demo.model.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    // Find bookings that overlap with given start and end time for conflict check
    List<Booking> findByFacilityAndStartTimeLessThanAndEndTimeGreaterThan(
            Facility facility, LocalDateTime start, LocalDateTime end);
}
