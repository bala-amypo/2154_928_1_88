package com.example.demo.model;

import lombok.*;
import jakarta.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "facilities", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String openTime;
    private String closeTime;
}
