package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.model.ApartmentUnit;
import com.example.demo.repository.ApartmentUnitRepository;
import com.example.demo.service.ApartmentUnitService;

@Service
public class ApartmentUnitServiceImpl implements ApartmentUnitService {

    private final ApartmentUnitRepository repo;

    public ApartmentUnitServiceImpl(ApartmentUnitRepository repo) {
        this.repo = repo;
    }

    public ApartmentUnit saveUnit(ApartmentUnit unit) {
        return repo.save(unit);
    }

    public List<ApartmentUnit> getAllUnits() {
        return repo.findAll();
    }
}
