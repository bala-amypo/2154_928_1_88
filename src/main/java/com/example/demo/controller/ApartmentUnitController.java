// File: src/main/java/com/example/demo/controller/ApartmentUnitController.java
package com.example.demo.controller;

import com.example.demo.entity.ApartmentUnit;
import com.example.demo.service.ApartmentUnitService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/units")
public class ApartmentUnitController {

    private final ApartmentUnitService unitService;

    public ApartmentUnitController(ApartmentUnitService unitService) {
        this.unitService = unitService;
    }

    @PostMapping("/assign/{userId}")
    public ResponseEntity<ApartmentUnit> assignUnit(
            @PathVariable Long userId,
            @Valid @RequestBody ApartmentUnit apartmentUnit) {
        ApartmentUnit savedUnit = unitService.assignUnit(userId, apartmentUnit);
        return ResponseEntity.ok(savedUnit);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getUserUnits(@PathVariable Long userId) {
        return ResponseEntity.ok(unitService.getUnitsByUser(userId));
    }
}
