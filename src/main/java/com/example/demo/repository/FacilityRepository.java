package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.*;
public interface FacilityRepository extends JpaRepository<Facility, Long> {}
