package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "apartment_units")
public class ApartmentUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String unitNumber;
    private int floor;

    @ManyToOne
    private User owner;

    // Getters and Setters
    public Long getId() { return id; }

    public String getUnitNumber() { return unitNumber; }
    public void setUnitNumber(String unitNumber) { this.unitNumber = unitNumber; }

    public int getFloor() { return floor; }
    public void setFloor(int floor) { this.floor = floor; }

    public User getOwner() { return owner; }
    public void setOwner(User owner) { this.owner = owner; }
}
