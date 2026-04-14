package com.microservices.paciente.services;



import com.microservices.paciente.models.Patient;

import java.util.List;

public interface IPatientService {
    List<Patient> findAll();
    Patient findById(Long id);
    void update(Long id, Patient patient);
    void save(Patient patient);
    void deleteById(Long id);
}