package com.example.demo.service;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private Map<String, User> users = new HashMap<>();
    private Long userIdCounter = 1L;

    @Override
    public User register(RegisterRequest request) {
        User user = new User();
        user.setId(userIdCounter++);
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); // in production, hash password!
        users.put(user.getEmail(), user);
        return user;
    }

    @Override
    public User login(LoginRequest request) {
        User user = users.get(request.getEmail());
        if (user != null && user.getPassword().equals(request.getPassword())) {
            return user;
        }
        throw new RuntimeException("Invalid email or password");
    }
}
