package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.ApartmentUnit;
import com.example.demo.service.ApartmentUnitService;

@RestController
@RequestMapping("/units")
public class ApartmentUnitController {

    @Autowired
    private ApartmentUnitService unitService;

    @PostMapping("/assign/{userId}")
    public ApartmentUnit assignUnit(@PathVariable Long userId) {
        return unitService.assignUnit(userId);
    }

    @GetMapping("/user/{userId}")
    public ApartmentUnit getUnitByUser(@PathVariable Long userId) {
        return unitService.getUnitByUserId(userId);
    }
}
