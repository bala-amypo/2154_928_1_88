// File: src/main/java/com/example/demo/service/ApartmentUnitService.java
package com.example.demo.service;

import com.example.demo.entity.ApartmentUnit;

import java.util.List;

public interface ApartmentUnitService {
    ApartmentUnit assignUnit(ApartmentUnit unit, Long userId);
    List<ApartmentUnit> getUnitsByUser(Long userId);
}
