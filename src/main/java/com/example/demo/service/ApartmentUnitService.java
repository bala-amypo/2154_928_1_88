package com.example.demo.service;

import java.util.List;
import com.example.demo.model.ApartmentUnit;

public interface ApartmentUnitService {
    ApartmentUnit saveUnit(ApartmentUnit unit);
    List<ApartmentUnit> getAllUnits();
}
