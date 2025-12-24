package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.ApartmentUnit;
import com.example.demo.model.User;
import com.example.demo.repository.ApartmentUnitRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ApartmentUnitService;

@Service
@Transactional
public class ApartmentUnitServiceImpl implements ApartmentUnitService {

    private final ApartmentUnitRepository apartmentUnitRepository;
    private final UserRepository userRepository;

    public ApartmentUnitServiceImpl(ApartmentUnitRepository apartmentUnitRepository,
                                    UserRepository userRepository) {
        this.apartmentUnitRepository = apartmentUnitRepository;
        this.userRepository = userRepository;
    }

    /**
     * Assign a unit to a user
     */
    @Override
    public ApartmentUnit assignUnitToUser(Long userId, ApartmentUnit unit) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BadRequestException("User not found"));

        // ❗ Business validation
        if (apartmentUnitRepository.existsByUnitNumber(unit.getUnitNumber())) {
            throw new BadRequestException("Unit number already exists");
        }

        // Optional: prevent multiple units per user
        apartmentUnitRepository.findUnitByUserId(userId).ifPresent(u -> {
            throw new BadRequestException("User already owns a unit");
        });

        unit.setOwner(user);
        return apartmentUnitRepository.save(unit);
    }

    /**
     * Get unit by user using HQL
     */
    @Override
    @Transactional(readOnly = true)
    public ApartmentUnit getUnitByUser(Long userId) {

        // Only check user existence if required
        if (!userRepository.existsById(userId)) {
            throw new BadRequestException("User not found");
        }

        return apartmentUnitRepository.findUnitByUserId(userId)
                .orElseThrow(() -> new BadRequestException("Unit not found for this user"));
    }
}
