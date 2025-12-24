package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Facility;

public interface FacilityRepository extends JpaRepository<Facility, Long> {

    Optional<Facility> findByName(String name);

    @Query("SELECT f FROM Facility f WHERE LOWER(f.name) = LOWER(:name)")
    Optional<Facility> findByNameIgnoreCase(@Param("name") String name);

    @Query("SELECT f FROM Facility f ORDER BY f.name ASC")
    List<Facility> findAllOrderByName();
}
