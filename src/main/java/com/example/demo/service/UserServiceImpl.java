package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.service.AuthService;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository repo;

    public AuthServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    public User register(User user) {
        return repo.save(user);
    }

    public User login(User user) {
        return repo.findAll().stream()
                .filter(u -> u.getEmail().equals(user.getEmail()))
                .findFirst()
                .orElse(null);
    }
}
