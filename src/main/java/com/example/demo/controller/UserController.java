package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.dto.RegisterRequest;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) { this.userService = userService; }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody RegisterRequest req) {
        User u = new User(null, req.getName(), req.getEmail(), req.getPassword(), "RESIDENT");
        User saved = userService.register(u);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        // Normally userService.getUserById
        return ResponseEntity.ok(new User(id, "Test", "test@e.com", "p", "RESIDENT"));
    }
}
