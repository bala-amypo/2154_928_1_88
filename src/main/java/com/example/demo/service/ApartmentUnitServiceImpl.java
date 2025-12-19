package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.ApartmentUnit;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ApartmentUnitRepository;
import com.example.demo.repository.UserRepository;

@Service
public class ApartmentUnitServiceImpl implements ApartmentUnitService {

    private final ApartmentUnitRepository unitRepository;
    private final UserRepository userRepository;

    public ApartmentUnitServiceImpl(
            ApartmentUnitRepository unitRepository,
            UserRepository userRepository) {
        this.unitRepository = unitRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ApartmentUnit assignUnit(Long userId, ApartmentUnit unit) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with id " + userId));

        // 🔥 CRITICAL FIX
        unit.setId(null);   // forces INSERT, avoids 400 error
        unit.setUser(user);

        return unitRepository.save(unit);
    }
}
