package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ApartmentUnit;
import com.example.demo.model.User;
import com.example.demo.repository.ApartmentUnitRepository;
import com.example.demo.repository.UserRepository;

@Service
public class ApartmentUnitServiceImpl {

    @Autowired
    private ApartmentUnitRepository unitRepository;

    @Autowired
    private UserRepository userRepository;

    public ApartmentUnit assignUnitToUser(Long userId, ApartmentUnit unit) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        unit.setOwner(user); // ✅ ensure ApartmentUnit has setOwner(User)
        return unitRepository.save(unit);
    }
}
