package com.example.demo.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/auth")
@Validated
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // ✅ POST REGISTER
    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody User user) {
        return ResponseEntity.ok(userService.register(user));
    }

    // ✅ GET LOGIN (Trainer required)
    @GetMapping("/login")
    public ResponseEntity<User> login(
            @RequestParam
            @Email(message = "Invalid email format")
            @NotBlank(message = "Email is required")
            String email,

            @RequestParam
            @NotBlank(message = "Password is required")
            String password) {

        return ResponseEntity.ok(userService.login(email, password));
    }
}
