package com.example.demo.security;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository repo;

    public CustomUserDetailsService(UserRepository repo){ this.repo = repo; }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = repo.findByUsername(username);
        if(user == null) throw new UsernameNotFoundException("User Not Found");
        return User.withUsername(user.getUsername())
                .password(user.getPassword())
                .roles("USER").build();
    }
}
