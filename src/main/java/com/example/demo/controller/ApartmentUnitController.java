package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.entity.ApartmentUnit;
import com.example.demo.service.ApartmentUnitService;

@RestController
@RequestMapping("/assign")
public class ApartmentUnitController {

    private final ApartmentUnitService service;

    public ApartmentUnitController(ApartmentUnitService service) {
        this.service = service;
    }

    @PostMapping
    public ApartmentUnit create(@RequestBody ApartmentUnit assign) {
        return service.save(assign);
    }

    @GetMapping
    public List<ApartmentUnit> getAll() {
        return service.findAll();
    }
}

