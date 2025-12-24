package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.ApartmentUnit;

public interface ApartmentUnitRepository extends JpaRepository<ApartmentUnit, Long> {

    // ✅ HQL / JPQL query
    @Query("SELECT au FROM ApartmentUnit au WHERE au.owner.id = :userId")
    Optional<ApartmentUnit> findUnitByUserId(@Param("userId") Long userId);

    
    boolean existsByUnitNumber(String unitNumber);
}
