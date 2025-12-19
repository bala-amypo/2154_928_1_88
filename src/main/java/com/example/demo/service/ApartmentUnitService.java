package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.ApartmentUnit;
import com.example.demo.repository.ApartmentUnitRepository;

@Service
public class ApartmentUnitService {

    private final ApartmentUnitRepository repository;

    public ApartmentUnitService(ApartmentUnitRepository repository) {
        this.repository = repository;
    }

    public ApartmentUnit assignUnit(Long userId, ApartmentUnit unit) {
        unit.setUserId(userId);
        return repository.save(unit);
    }

    public List<ApartmentUnit> getUnitsByUser(Long userId) {
        return repository.findByUserId(userId);
    }
}
