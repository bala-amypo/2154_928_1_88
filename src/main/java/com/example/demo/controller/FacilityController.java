package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Facility;
import com.example.demo.service.FacilityService;

@RestController
@RequestMapping("/facilities")
public class FacilityController {

    private final FacilityService service;

    public FacilityController(FacilityService service) {
        this.service = service;
    }

    @PostMapping
    public Facility save(@RequestBody Facility facility) {
        return service.saveFacility(facility);
    }

    @GetMapping
    public List<Facility> getAll() {
        return service.getAllFacilities();
    }
}
