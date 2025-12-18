package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.entity.Facility;
import com.example.demo.service.FacilityService;

@RestController
@RequestMapping("/facilities")
public class FacilityController {

    private final FacilityService service;

    public FacilityController(FacilityService service) {
        this.service = service;
    }

    @PostMapping
    public Facility create(@RequestBody Facility facility) {
        return service.save(facility);
    }

    @GetMapping
    public List<Facility> getAll() {
        return service.findAll();
    }
}
