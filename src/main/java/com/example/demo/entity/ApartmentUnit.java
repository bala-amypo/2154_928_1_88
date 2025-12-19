package com.example.demo.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "apartment_unit")
public class ApartmentUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String unitNumber;
    private int floor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    // ===== REQUIRED GETTERS & SETTERS =====

    public Long getId() {
        return id;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public int getFloor() {
        return floor;
    }

    public User getUser() {
        return user;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setUser(User user) {   // ✅ FIX
        this.user = user;
    }
}
