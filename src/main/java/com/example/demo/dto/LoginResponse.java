package com.example.demo.dto;

public class LoginResponse {
    private Long id;
    private String email;
    private String token;

    public LoginResponse(Long id, String email, String token) {
        this.id = id;
        this.email = email;
        this.token = token;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
}
