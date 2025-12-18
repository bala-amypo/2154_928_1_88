package com.example.demo.service;

import com.example.demo.entity.ApartmentUnit;
import java.util.List;

public interface ApartmentUnitService {
    ApartmentUnit save(ApartmentUnit unit);
    List<ApartmentUnit> findAll();
}
