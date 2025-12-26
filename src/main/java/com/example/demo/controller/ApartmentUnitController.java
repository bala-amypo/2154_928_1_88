package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import com.example.demo.model.ApartmentUnit;
import com.example.demo.service.ApartmentUnitService;
import com.example.demo.security.JwtTokenProvider;


@RestController
@RequestMapping("/units")
@Validated
public class ApartmentUnitController {

    private final ApartmentUnitService apartmentUnitService;
    public ApartmentUnitController(ApartmentUnitService service) { this.apartmentUnitService = service; }

    @PostMapping("/assign/{userId}")
    public ResponseEntity<ApartmentUnit> assignUnit(@PathVariable Long userId, @RequestBody ApartmentUnit unit) {
        ApartmentUnit saved = apartmentUnitService.assignUnitToUser(userId, unit);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<ApartmentUnit> getUnitByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(apartmentUnitService.getUnitByUser(userId));
    }
}
