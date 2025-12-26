package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.model.Facility;
import com.example.demo.repository.FacilityRepository;
import com.example.demo.service.FacilityService;
import com.example.demo.exception.BadRequestException;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class FacilityServiceImpl implements FacilityService {

    private final FacilityRepository repo;

    public FacilityServiceImpl(FacilityRepository repo){
        this.repo = repo;
    }

    @Override
    public Facility addFacility(Facility f){
        Optional<Facility> existing = repo.findByName(f.getName());
        if(existing.isPresent()) throw new BadRequestException("Facility already exists");

        LocalTime open = LocalTime.parse(f.getOpenTime());
        LocalTime close = LocalTime.parse(f.getCloseTime());
        if(open.isAfter(close)) throw new BadRequestException("Invalid opening hours");

        return repo.save(f);
    }

    @Override
    public List<Facility> getAllFacilities(){
        return repo.findAll();
    }
}
