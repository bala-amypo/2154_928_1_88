package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.ApartmentUnit;
import com.example.demo.model.User;
import java.util.Optional;

public interface ApartmentUnitRepository extends JpaRepository<ApartmentUnit, Long> {
    Optional<ApartmentUnit> findByOwner(User owner);
}
