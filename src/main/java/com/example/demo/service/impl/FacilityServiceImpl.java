package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.Facility;
import com.example.demo.repository.FacilityRepository;
import com.example.demo.service.FacilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FacilityServiceImpl implements FacilityService {
    
    private final FacilityRepository facilityRepository;
    
    @Override
    public Facility addFacility(Facility facility) {
        if (facilityRepository.findByName(facility.getName()).isPresent()) {
            throw new BadRequestException("Facility with this name already exists");
        }
        
        // Validate opening hours
        if (facility.getCloseTime().compareTo(facility.getOpenTime()) <= 0) {
            throw new BadRequestException("Close time must be after open time");
        }
        
        return facilityRepository.save(facility);
    }
    
    @Override
    public List<Facility> getAllFacilities() {
        return facilityRepository.findAll();
    }
}