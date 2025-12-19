package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ApartmentUnit> units;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Booking> bookings;

    // ===== REQUIRED GETTERS & SETTERS =====

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {          // ✅ FIX
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) { // ✅ FIX
        this.email = email;
    }

    public List<ApartmentUnit> getUnits() {
        return units;
    }

    public void setUnits(List<ApartmentUnit> units) {
        this.units = units;
    }
}
