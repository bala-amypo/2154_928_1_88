package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {

    private final AuthenticationManager authManager;
    private final JwtTokenProvider jwt;
    private final UserService service;

    public UserController(AuthenticationManager authManager, JwtTokenProvider jwt, UserService service){
        this.authManager = authManager;
        this.jwt = jwt;
        this.service = service;
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest req){
        service.register(req);
        return "User Registered Successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest req){
        Authentication auth =
                authManager.authenticate(new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));
        return "{\"token\":\""+jwt.createToken(req.getUsername())+"\"}";
    }
}
