// File: src/main/java/com/example/demo/service/ApartmentUnitServiceImpl.java
package com.example.demo.service;

import com.example.demo.entity.ApartmentUnit;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ApartmentUnitRepo;
import com.example.demo.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class ApartmentUnitServiceImpl implements ApartmentUnitService {

    private final ApartmentUnitRepo unitRepo;
    private final UserRepo userRepo;

    public ApartmentUnitServiceImpl(ApartmentUnitRepo unitRepo, UserRepo userRepo) {
        this.unitRepo = unitRepo;
        this.userRepo = userRepo;
    }

    @Override
    public ApartmentUnit assignUnit(Long userId, ApartmentUnit apartmentUnit) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));

        apartmentUnit.setUser(user);
        return unitRepo.save(apartmentUnit);
    }
}
