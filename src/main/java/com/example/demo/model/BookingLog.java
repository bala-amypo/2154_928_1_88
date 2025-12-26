package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "booking_logs")
public class BookingLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Booking booking;

    private String logMessage;

    private LocalDateTime loggedAt;

    public BookingLog() {}

    public BookingLog(Long id, Booking b, String msg, LocalDateTime t){
        this.id = id;
        this.booking = b;
        this.logMessage = msg;
        this.loggedAt = t;
    }

    public void onCreate(){ if(this.loggedAt == null) this.loggedAt = LocalDateTime.now(); }

    // getters & setters
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public Booking getBooking(){return booking;} public void setBooking(Booking b){this.booking=b;}
    public String getLogMessage(){return logMessage;} public void setLogMessage(String m){this.logMessage=m;}
    public LocalDateTime getLoggedAt(){return loggedAt;} public void setLoggedAt(LocalDateTime t){this.loggedAt=t;}
}
