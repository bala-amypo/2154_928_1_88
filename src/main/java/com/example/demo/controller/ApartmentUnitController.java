package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

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
    public ApartmentUnit assignUnit(
            @PathVariable Long userId,
            @RequestBody ApartmentUnit unit) {

        return service.assignUnit(userId, unit);
    }
}
