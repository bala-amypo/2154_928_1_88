package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/user/{userId}")
    public List<ApartmentUnit> getUnitsByUser(
            @PathVariable Long userId) {
        return service.getUnitsByUser(userId);
    }
}
