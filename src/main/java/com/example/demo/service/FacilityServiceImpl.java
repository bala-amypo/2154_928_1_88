package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.service.FacilityService;
import com.example.demo.entity.Facility;
import com.example.demo.repository.FacilityRepository;

@Service
public class FacilityServiceImpl implements FacilityService {

    private final FacilityRepository repo;

    public FacilityServiceImpl(FacilityRepository repo) {
        this.repo = repo;
    }

    public Facility save(Facility facility) {
        return repo.save(facility);
    }

    public List<Facility> findAll() {
        return repo.findAll();
    }
}
