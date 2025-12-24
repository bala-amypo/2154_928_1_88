package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    
    @Query("SELECT u FROM User u WHERE u.email = :email")
    Optional<User> findByEmail(@Param("email") String email);

    
    @Query("SELECT u FROM User u WHERE u.email = :email AND u.password = :password")
    Optional<User> findByEmailAndPassword(
            @Param("email") String email,
            @Param("password") String password
    );
}
