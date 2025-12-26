package com.example.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.ApartmentUnit;

public interface ApartmentUnitRepository extends JpaRepository<ApartmentUnit, Long> {
    
    // Find apartment unit by Owner's user ID
    Optional<ApartmentUnit> findByOwnerId(Long ownerId);
}
