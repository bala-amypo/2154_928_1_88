package com.example.demo.dto;

import java.time.LocalDateTime;

public class BookingRequest {
    private Long userId;
    private Long facilityId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public BookingRequest() {}

    // getters & setters
    public Long getUserId(){ return userId; }
    public void setUserId(Long userId){ this.userId = userId; }

    public Long getFacilityId(){ return facilityId; }
    public void setFacilityId(Long facilityId){ this.facilityId = facilityId; }

    public LocalDateTime getStartTime(){ return startTime; }
    public void setStartTime(LocalDateTime startTime){ this.startTime = startTime; }

    public LocalDateTime getEndTime(){ return endTime; }
    public void setEndTime(LocalDateTime endTime){ this.endTime = endTime; }
}
