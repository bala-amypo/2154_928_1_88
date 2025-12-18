package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.ApartmentUnit;
import com.example.demo.service.ApartmentUnitService;

@RestController
@RequestMapping("/units")
public class ApartmentUnitController {

    private final ApartmentUnitService service;

    public ApartmentUnitController(ApartmentUnitService service) {
        this.service = service;
    }

    @PostMapping
    public ApartmentUnit save(@RequestBody ApartmentUnit unit) {
        return service.saveUnit(unit);
    }

    @GetMapping
    public List<ApartmentUnit> getAll() {
        return service.getAllUnits();
    }
}


