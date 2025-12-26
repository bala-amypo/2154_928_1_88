package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.model.User;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User register(RegisterRequest request) {
        // Check if email already exists
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword()); // encode if using Spring Security
        user.setEmail(request.getEmail());
        user.setRole("USER");

        return userRepository.save(user);
    }
}
