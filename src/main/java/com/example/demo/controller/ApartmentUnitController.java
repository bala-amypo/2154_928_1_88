// File: src/main/java/com/example/demo/controller/ApartmentUnitController.java
package com.example.demo.controller;

import com.example.demo.entity.ApartmentUnit;
import com.example.demo.service.ApartmentUnitService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/units")
public class ApartmentUnitController {

    private final ApartmentUnitService unitService;

    public ApartmentUnitController(ApartmentUnitService unitService) {
        this.unitService = unitService;
    }

    // Assign a unit to a user
    @PostMapping("/assign/{userId}")
    public ResponseEntity<ApartmentUnit> assignUnit(@PathVariable Long userId,
                                                    @Valid @RequestBody ApartmentUnit unit) {
        ApartmentUnit savedUnit = unitService.assignUnit(unit, userId);
        return ResponseEntity.ok(savedUnit);
    }

    // Get all units assigned to a user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ApartmentUnit>> getUnitsByUser(@PathVariable Long userId) {
        List<ApartmentUnit> units = unitService.getUnitsByUser(userId);
        return ResponseEntity.ok(units);
    }
}
