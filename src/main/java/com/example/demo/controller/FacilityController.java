package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import java.util.List;
import com.example.demo.model.Facility;
import com.example.demo.service.FacilityService;

@RestController
@RequestMapping("/facilities")
@Validated
public class FacilityController {

    private final FacilityService facilityService;
    public FacilityController(FacilityService service) { this.facilityService = service; }

    @PostMapping
    public ResponseEntity<Facility> addFacility(@RequestBody Facility f) {
        Facility saved = facilityService.addFacility(f);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<Facility>> getAllFacilities() {
        List<Facility> list = facilityService.getAllFacilities();
        return ResponseEntity.ok(list);
    }
}
