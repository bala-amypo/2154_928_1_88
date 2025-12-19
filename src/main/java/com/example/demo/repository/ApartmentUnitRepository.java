package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.ApartmentUnit;

public interface ApartmentUnitRepository extends JpaRepository<ApartmentUnit, Long> {
    List<ApartmentUnit> findByUserId(Long userId);
}
