// File: src/main/java/com/example/demo/controller/FacilityController.java
package com.example.demo.controller;

import com.example.demo.entity.Facility;
import com.example.demo.service.FacilityService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facilities")
public class FacilityController {

    private final FacilityService facilityService;

    public FacilityController(FacilityService facilityService) {
        this.facilityService = facilityService;
    }

    @GetMapping
    public ResponseEntity<List<Facility>> getAllFacilities() {
        return ResponseEntity.ok(facilityService.getAllFacilities());
    }

    @PostMapping
    public ResponseEntity<Facility> createFacility(@Valid @RequestBody Facility facility) {
        return ResponseEntity.ok(facilityService.saveFacility(facility));
    }
}
