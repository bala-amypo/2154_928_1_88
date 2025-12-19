package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.ApartmentUnit;

public interface ApartmentUnitService {
    ApartmentUnit save(ApartmentUnit unit, Long userId);
    List<ApartmentUnit> findByUserId(Long userId);
}
