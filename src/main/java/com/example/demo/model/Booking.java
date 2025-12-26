package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Facility facility;

    @ManyToOne
    private User user;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String status = STATUS_CONFIRMED;

    public static final String STATUS_CONFIRMED = "CONFIRMED";
    public static final String STATUS_CANCELLED = "CANCELLED";

    public Booking() {}

    public Booking(Long id, Facility f, User u, LocalDateTime start, LocalDateTime end, String status){
        this.id = id;
        this.facility = f;
        this.user = u;
        this.startTime = start;
        this.endTime = end;
        this.status = status;
    }

    // getters & setters
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public Facility getFacility(){return facility;} public void setFacility(Facility f){this.facility=f;}
    public User getUser(){return user;} public void setUser(User u){this.user=u;}
    public LocalDateTime getStartTime(){return startTime;} public void setStartTime(LocalDateTime s){this.startTime=s;}
    public LocalDateTime getEndTime(){return endTime;} public void setEndTime(LocalDateTime e){this.endTime=e;}
    public String getStatus(){return status;} public void setStatus(String s){this.status=s;}
}
