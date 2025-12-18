package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.service.ApartmentUnitService;
import com.example.demo.entity.ApartmentUnit;
import com.example.demo.repository.ApartmentUnitRepository;

@Service
public class ApartmentUnitServiceImpl implements ApartmentUnitService {

    private final ApartmentUnitRepository repo;

    public ApartmentUnitServiceImpl(ApartmentUnitRepository repo) {
        this.repo = repo;
    }

    public ApartmentUnit save(ApartmentUnit unit) {
        return repo.save(unit);
    }

    public List<ApartmentUnit> findAll() {
        return repo.findAll();
    }
}
