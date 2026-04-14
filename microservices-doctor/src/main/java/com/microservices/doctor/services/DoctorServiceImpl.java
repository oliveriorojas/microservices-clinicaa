package com.microservices.doctor.services;

import com.microservices.doctor.models.Doctor;
import com.microservices.doctor.repository.IDoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements IDoctorService {

    @Autowired
    private IDoctorRepository doctorRepository;

    @Override
    public List<Doctor> findAll() {
        return (List<Doctor>) doctorRepository.findAll();
    }

    @Override
    public Doctor findById(Long id) {
        return doctorRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    @Override
    public void update(Long id, Doctor doctor) {
        Doctor doctorDb = doctorRepository.findById(id).orElseThrow();
        doctorDb.setFirstName(doctor.getFirstName());
        doctorDb.setLastName(doctor.getLastName());
        doctorDb.setSpecialty(doctor.getSpecialty());
        doctorDb.setLicenseNumber(doctor.getLicenseNumber());
        doctorRepository.save(doctorDb);
    }

    @Override
    public void deleteById(Long id) {
        doctorRepository.deleteById(id);
    }
}