package com.example.demo.controller;

import com.example.demo.entity.Facility;
import com.example.demo.service.FacilityService;
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
    public List<Facility> getAllFacilities() {
        return facilityService.getAllFacilities();
    }

    @PostMapping
    public Facility createFacility(@RequestBody Facility facility) {
        return facilityService.saveFacility(facility);
    }
}
