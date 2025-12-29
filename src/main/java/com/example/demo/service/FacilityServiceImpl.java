package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.Facility;
import com.example.demo.repository.FacilityRepository;
import com.example.demo.service.FacilityService;

@Service
@Transactional
public class FacilityServiceImpl implements FacilityService {

    private final FacilityRepository facilityRepository;

    public FacilityServiceImpl(FacilityRepository facilityRepository) {
        this.facilityRepository = facilityRepository;
    }

    @Override
    public Facility addFacility(Facility facility) {

        // ✅ Business validation
        if (facility.getOpenTime().compareTo(facility.getCloseTime()) >= 0) {
            throw new BadRequestException("Open time must be before close time");
        }

        // ✅ HQL-based check
        if (facilityRepository.existsByNameHql(facility.getName())) {
            throw new BadRequestException("Facility already exists");
        }

        return facilityRepository.save(facility);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Facility> getAllFacilities() {
        // ✅ Using HQL
        return facilityRepository.findAllFacilitiesHql();
    }
}