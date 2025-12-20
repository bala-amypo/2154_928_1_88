package com.example.demo.controller;

import com.example.demo.entity.ApartmentUnit;
import com.example.demo.service.ApartmentUnitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/units")
public class ApartmentUnitController {

    private final ApartmentUnitService apartmentUnitService;

    public ApartmentUnitController(ApartmentUnitService apartmentUnitService) {
        this.apartmentUnitService = apartmentUnitService;
    }

    @GetMapping
    public List<ApartmentUnit> getAllUnits() {
        return apartmentUnitService.getAllUnits();
    }

    @PostMapping
    public ApartmentUnit createUnit(@RequestBody ApartmentUnit unit) {
        return apartmentUnitService.saveUnit(unit);
    }

    @PostMapping("/assign/{userId}")
    public ApartmentUnit assignUnitToUser(
            @PathVariable Long userId,
            @RequestParam Long unitId) {
        return apartmentUnitService.assignUnitToUser(unitId, userId);
    }

    @GetMapping("/user/{userId}")
    public List<ApartmentUnit> getUnitsByUser(@PathVariable Long userId) {
        return apartmentUnitService.getUnitsByUser(userId);
    }
}
