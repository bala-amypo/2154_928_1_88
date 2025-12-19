// File: src/main/java/com/example/demo/service/ApartmentUnitServiceImpl.java
package com.example.demo.service;

import com.example.demo.entity.ApartmentUnit;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ApartmentUnitRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmentUnitServiceImpl {

    private final ApartmentUnitRepository unitRepository;
    private final UserRepository userRepository;

    public ApartmentUnitServiceImpl(ApartmentUnitRepository unitRepository,
                                    UserRepository userRepository) {
        this.unitRepository = unitRepository;
        this.userRepository = userRepository;
    }

    public ApartmentUnit assignUnit(ApartmentUnit unit, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
        unit.setUser(user);
        return unitRepository.save(unit);
    }

    public List<ApartmentUnit> getUnitsByUser(Long userId) {
        userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
        return unitRepository.findByUserId(userId);
    }
}
