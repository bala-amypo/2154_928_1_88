package com.example.demo.service.impl;

import com.example.demo.model.ApartmentUnit;
import com.example.demo.model.User;
import com.example.demo.repository.ApartmentUnitRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ApartmentUnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApartmentUnitServiceImpl implements ApartmentUnitService {
    
    private final ApartmentUnitRepository apartmentUnitRepository;
    private final UserRepository userRepository;
    
    @Override
    public ApartmentUnit assignUnitToUser(Long userId, ApartmentUnit unit) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
        
        unit.setOwner(user);
        return apartmentUnitRepository.save(unit);
    }
    
    @Override
    public ApartmentUnit getUnitByUser(Long userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
        
        return apartmentUnitRepository.findByOwner(user)
            .orElseThrow(() -> new RuntimeException("Unit not found"));
    }
}