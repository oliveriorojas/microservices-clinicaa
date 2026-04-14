package com.microservices.prescription.services;

import com.microservices.prescription.models.Prescription;
import java.util.List;

public interface IPrescriptionService {
    List<Prescription> findAll();
    Prescription findById(Long id);
    void save(Prescription prescription);
    void deleteById(Long id);
    void update(Long id, Prescription prescription);
}