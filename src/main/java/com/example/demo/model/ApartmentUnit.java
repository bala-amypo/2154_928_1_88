package com.example.demo.model;

import lombok.*;
import jakarta.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "apartment_units", uniqueConstraints = @UniqueConstraint(columnNames = "unitNumber"))
public class ApartmentUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String unitNumber;
    private Integer floor;

    @OneToOne
    private User owner;
}
