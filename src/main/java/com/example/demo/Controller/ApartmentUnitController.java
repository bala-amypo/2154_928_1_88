package com.example.demo.controller;

import com.example.demo.model.ApartmentUnit;
import com.example.demo.service.ApartmentUnitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/units")
public class ApartmentUnitController {

    private final ApartmentUnitService unitService;

    public ApartmentUnitController(ApartmentUnitService unitService){
        this.unitService = unitService;
    }

    @PostMapping("/assign/{userId}")
    public ResponseEntity<ApartmentUnit> assignUnitToUser(@PathVariable Long userId,
                                                          @RequestBody ApartmentUnit unit){
        ApartmentUnit savedUnit = unitService.assignUnitToUser(userId, unit);
        return ResponseEntity.ok(savedUnit);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<ApartmentUnit> getUnitByUser(@PathVariable Long userId){
        ApartmentUnit unit = unitService.getUnitByUser(userId);
        return ResponseEntity.ok(unit);
    }
}
