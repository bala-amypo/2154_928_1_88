package com.example.demo.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.entity.ApartmentUnit;
import com.example.demo.service.ApartmentUnitService;

@RestController
@RequestMapping("/units")
public class ApartmentUnitController {

    private final ApartmentUnitService service;

    public ApartmentUnitController(ApartmentUnitService service) {
        this.service = service;
    }

    @PostMapping("/assign/{userId}")
    public ApartmentUnit create(
            @PathVariable Long userId,
            @Valid @RequestBody ApartmentUnit units) {

        return service.save(units, userId);
    }

    @GetMapping("/user/{userId}")
    public List<ApartmentUnit> getAll(@PathVariable Long userId) {
        return service.findByUserId(userId);
    }
}
