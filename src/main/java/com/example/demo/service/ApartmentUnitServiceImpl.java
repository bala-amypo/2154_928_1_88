package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.model.ApartmentUnit;
import com.example.demo.model.User;
import com.example.demo.repository.ApartmentUnitRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ApartmentUnitService;

import java.util.Optional;

@Service
public class ApartmentUnitServiceImpl implements ApartmentUnitService {

    private final ApartmentUnitRepository unitRepo;
    private final UserRepository userRepo;

    public ApartmentUnitServiceImpl(ApartmentUnitRepository unitRepo, UserRepository userRepo){
        this.unitRepo = unitRepo;
        this.userRepo = userRepo;
    }

    @Override
    public ApartmentUnit assignUnitToUser(Long userId, ApartmentUnit unit){
        User user = userRepo.findById(userId).orElseThrow();
        unit.setOwner(user);
        ApartmentUnit saved = unitRepo.save(unit);
        user.setApartmentUnit(saved);
        return saved;
    }

    @Override
    public ApartmentUnit getUnitByUser(Long userId){
        User user = userRepo.findById(userId).orElseThrow();
        return unitRepo.findByOwner(user).orElse(null);
    }
}
