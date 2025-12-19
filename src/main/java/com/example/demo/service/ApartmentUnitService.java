package com.example.demo.service;

import com.example.demo.entity.ApartmentUnit;

public interface ApartmentUnitService {

    ApartmentUnit assignUnit(Long userId, ApartmentUnit unit);
}
