package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "apartment_units")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApartmentUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String unitNumber;
    private int floor;
    
    @OneToOne
    @JoinColumn(name = "owner_id")
    private User owner;
    
    // Constructor for test compatibility
    public ApartmentUnit(Long id, String unitNumber, int floor, User owner) {
        this.id = id;
        this.unitNumber = unitNumber;
        this.floor = floor;
        this.owner = owner;
    }
}