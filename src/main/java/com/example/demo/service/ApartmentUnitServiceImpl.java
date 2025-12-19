package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.ApartmentUnit;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ApartmentUnitRepository;
import com.example.demo.repository.UserRepository;

@Service
public class ApartmentUnitServiceImpl implements ApartmentUnitService {

    private final ApartmentUnitRepository unitRepo;
    private final UserRepository userRepo;

    public ApartmentUnitServiceImpl(ApartmentUnitRepository unitRepo, UserRepository userRepo) {
        this.unitRepo = unitRepo;
        this.userRepo = userRepo;
    }

    // BUSINESS VALIDATION: check if user exists before saving
    @Override
    public ApartmentUnit save(ApartmentUnit unit, Long userId) {
        User user = userRepo.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
        unit.setUser(user);
        return unitRepo.save(unit);
    }

    @Override
    public List<ApartmentUnit> findByUserId(Long userId) {
        return unitRepo.findByUserId(userId);
    }
}
