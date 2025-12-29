package com.example.demo.security;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import org.springframework.security.core.Authentication;
import java.util.Date;

@Component
public class JwtTokenProvider {

    private final String jwtSecret = "secretKey123";
    private final long jwtExpirationMs = 3600000;

    public String generateToken(Authentication authentication) {
        String email = authentication.getName();
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (JwtException ex) {
            return false;
        }
    }

    public String getEmailFromToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }
}
