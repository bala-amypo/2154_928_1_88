package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "facilities", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String description;

    // Format: HH:mm
    private String openTime;

    // Format: HH:mm
    private String closeTime;

    @PrePersist
    @PreUpdate
    public void validateTime() {
        if (openTime != null && closeTime != null) {
            if (openTime.compareTo(closeTime) >= 0) {
                throw new IllegalArgumentException("Open time must be before close time");
            }
        }
    }
}
