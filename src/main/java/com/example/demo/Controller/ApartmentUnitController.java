package com.example.demo.controller;

import com.example.demo.model.ApartmentUnit;
import com.example.demo.service.ApartmentUnitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Apartment Units")
@RestController
@RequestMapping("/units")
public class ApartmentUnitController {

    private final ApartmentUnitService apartmentUnitService;

    public ApartmentUnitController(ApartmentUnitService apartmentUnitService) {
        this.apartmentUnitService = apartmentUnitService;
    }

    @ApiOperation("Assign a unit to a user")
    @PostMapping("/assign/{userId}")
    public ApartmentUnit assignUnit(@PathVariable Long userId, @RequestBody ApartmentUnit unit) {
        return apartmentUnitService.assignUnitToUser(userId, unit);
    }

    @ApiOperation("Get a user's unit by userId")
    @GetMapping("/user/{userId}")
    public ApartmentUnit getUnit(@PathVariable Long userId) {
        return apartmentUnitService.getUnitByUser(userId);
    }
}
