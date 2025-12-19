package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "facility")
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "facility", cascade = CascadeType.ALL)
    private List<Booking> bookings;

    // getters & setters
}
