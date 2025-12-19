// File: src/main/java/com/example/demo/service/FacilityService.java
package com.example.demo.service;

import com.example.demo.entity.Facility;

import java.util.List;

public interface FacilityService {
    List<Facility> getAllFacilities();
    Facility saveFacility(Facility facility);
}
