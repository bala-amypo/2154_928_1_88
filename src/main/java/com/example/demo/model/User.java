package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;
    private String role;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ApartmentUnit> apartmentUnits = new ArrayList<>();

    // Constructors
    public User() {}

    public User(String username, String password, String email, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public List<ApartmentUnit> getApartmentUnits() { return apartmentUnits; }
    public void setApartmentUnits(List<ApartmentUnit> apartmentUnits) { this.apartmentUnits = apartmentUnits; }

    public void addApartmentUnit(ApartmentUnit unit) {
        apartmentUnits.add(unit);
        unit.setOwner(this);
    }

    public void removeApartmentUnit(ApartmentUnit unit) {
        apartmentUnits.remove(unit);
        unit.setOwner(null);
    }
}
