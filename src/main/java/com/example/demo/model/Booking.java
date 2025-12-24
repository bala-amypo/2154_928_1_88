package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "facility_id", nullable = false)
    private Facility facility;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String status;

    @PrePersist
    public void prePersist() {
        if (status == null || status.isEmpty()) {
            status = "CONFIRMED";
        }
        validateTime();
    }

    @PreUpdate
    public void preUpdate() {
        validateTime();
    }

    private void validateTime() {
        if (startTime == null || endTime == null) {
            throw new IllegalArgumentException("Start time and end time are required");
        }
        if (!endTime.isAfter(startTime)) {
            throw new IllegalArgumentException("End time must be after start time");
        }
    }
}
