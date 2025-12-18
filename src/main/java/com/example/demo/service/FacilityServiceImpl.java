package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.model.Facility;
import com.example.demo.repository.FacilityRepository;
import com.example.demo.service.FacilityService;

@Service
public class FacilityServiceImpl implements FacilityService {

    private final FacilityRepository repo;

    public FacilityServiceImpl(FacilityRepository repo) {
        this.repo = repo;
    }

    public Facility saveFacility(Facility facility) {
        return repo.save(facility);
    }

    public List<Facility> getAllFacilities() {
        return repo.findAll();
    }
}
