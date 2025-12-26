package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "apartment_units")
public class ApartmentUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String unitNumber;

    private Integer floor;

    @OneToOne
    private User owner;

    public ApartmentUnit() {}

    public ApartmentUnit(Long id, String unitNumber, Integer floor, User owner){
        this.id = id;
        this.unitNumber = unitNumber;
        this.floor = floor;
        this.owner = owner;
    }

    // getters & setters
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getUnitNumber(){return unitNumber;} public void setUnitNumber(String u){this.unitNumber=u;}
    public Integer getFloor(){return floor;} public void setFloor(Integer f){this.floor=f;}
    public User getOwner(){return owner;} public void setOwner(User u){this.owner=u;}
}
