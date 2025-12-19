// File: src/main/java/com/example/demo/service/ApartmentUnitService.java
package com.example.demo.service;

import com.example.demo.entity.ApartmentUnit;

public interface ApartmentUnitService {
    ApartmentUnit assignUnit(Long userId, ApartmentUnit apartmentUnit);
}
