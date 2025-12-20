package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ApartmentUnit;
import com.example.demo.model.User;

public interface ApartmentUnitRepository extends JpaRepository<ApartmentUnit, Long> {

    Optional<ApartmentUnit> findByOwner(User user);
}
