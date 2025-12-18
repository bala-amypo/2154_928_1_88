package com.example.demo.service;

import com.example.demo.entity.Facility;
import java.util.List;

public interface FacilityService {
    Facility save(Facility facility);
    List<Facility> findAll();
}
