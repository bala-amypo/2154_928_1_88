package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String email;
    private String password;
    private String role = "RESIDENT";
    
    @OneToOne(mappedBy = "owner", cascade = CascadeType.ALL)
    private ApartmentUnit apartmentUnit;
    
    // Constructor for test compatibility - REMOVE @AllArgsConstructor
    public User(Long id, String name, String email, String password, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}