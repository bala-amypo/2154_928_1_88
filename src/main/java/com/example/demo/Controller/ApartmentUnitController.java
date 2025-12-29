package com.example.demo.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.ApartmentUnit;
import com.example.demo.service.ApartmentUnitService;

@RestController
@RequestMapping("/units")
@Validated
public class ApartmentUnitController {

    private final ApartmentUnitService apartmentUnitService;

    public ApartmentUnitController(ApartmentUnitService apartmentUnitService) {
        this.apartmentUnitService = apartmentUnitService;
    }

    @PostMapping("/assign/{userId}")
    public ResponseEntity<ApartmentUnit> assignUnit(
            @PathVariable @NotNull(message = "User ID is required") Long userId,
            @Valid @RequestBody ApartmentUnit unit) {

        return ResponseEntity.ok(
                apartmentUnitService.assignUnitToUser(userId, unit)
        );
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<ApartmentUnit> getUnitByUser(
            @PathVariable @NotNull(message = "User ID is required") Long userId) {

        return ResponseEntity.ok(
                apartmentUnitService.getUnitByUser(userId)
        );
    }
}