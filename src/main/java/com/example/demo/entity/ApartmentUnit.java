// File: src/main/java/com/example/demo/entity/ApartmentUnit.java
package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class ApartmentUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Unit number is required")
    private String unitNumber;

    @NotNull(message = "Floor is required")
    private Integer floor;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUnitNumber() { return unitNumber; }
    public void setUnitNumber(String unitNumber) { this.unitNumber = unitNumber; }

    public Integer getFloor() { return floor; }
    public void setFloor(Integer floor) { this.floor = floor; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
