package com.microservices.doctor.services;


import com.microservices.doctor.models.Doctor;

import java.util.List;

public interface IDoctorService {
    List<Doctor> findAll();
    Doctor findById(Long id);
    void save(Doctor doctor);
    void update(Long id, Doctor doctor);
    void deleteById(Long id);
}