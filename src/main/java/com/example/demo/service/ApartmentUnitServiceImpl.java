package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.repository.ApartmentUnitRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.model.ApartmentUnit;
import com.example.demo.model.User;

@Service
public class ApartmentUnitServiceImpl implements ApartmentUnitService {

    @Autowired
    private ApartmentUnitRepository unitRepo;

    @Autowired
    private UserRepository userRepo;

    @Override
    public ApartmentUnit assignUnitToUser(Long userId, ApartmentUnit unit) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        unit.setOwner(user); // assign owner
        return unitRepo.save(unit);
    }

    @Override
    public ApartmentUnit getUnitByUser(Long userId) {
        return unitRepo.findByOwnerId(userId)
                .orElseThrow(() -> new RuntimeException("No unit assigned to this user"));
    }
}
