package com.example.demo.service;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private final Map<String, User> userDatabase = new HashMap<>();

    @Override
    public User register(RegisterRequest request) {
        User user = new User();
        user.setId((long) (userDatabase.size() + 1));
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());  // <-- set role
        userDatabase.put(user.getEmail(), user);
        return user;
    }

    @Override
    public User login(LoginRequest request) {
        User user = userDatabase.get(request.getEmail());
        if (user != null && user.getPassword().equals(request.getPassword())) {
            return user;
        }
        throw new RuntimeException("Invalid credentials");
    }
}
