package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Facility;

public interface FacilityRepository extends JpaRepository<Facility, Long> {

    Optional<Facility> findByName(String name);

    // ✅ HQL: get all facilities
    @Query("SELECT f FROM Facility f ORDER BY f.name")
    List<Facility> findAllFacilitiesHql();

    // ✅ HQL: check name exists
    @Query("SELECT COUNT(f) > 0 FROM Facility f WHERE f.name = :name")
    boolean existsByNameHql(@Param("name") String name);
}