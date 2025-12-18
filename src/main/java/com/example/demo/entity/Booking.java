package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookingDate;

    @ManyToOne
    private User user;

    @ManyToOne
    private Facility facility;
}
