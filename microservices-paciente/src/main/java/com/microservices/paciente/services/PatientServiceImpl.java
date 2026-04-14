package com.microservices.paciente.services;

import com.microservices.paciente.models.Patient;
import com.microservices.paciente.repository.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements IPatientService {

    @Autowired
    private IPatientRepository patientRepository;

    @Override
    public List<Patient> findAll() {
        return (List<Patient>) patientRepository.findAll();
    }

    @Override
    public Patient findById(Long id) {
        return patientRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public void update(Long id, Patient patient) {
        Patient patientDb = patientRepository.findById(id).orElseThrow();

        patientDb.setFirstName(patient.getFirstName());
        patientDb.setLastName(patient.getLastName());
        patientDb.setDni(patient.getDni());
        patientDb.setEmail(patient.getEmail());
        patientDb.setPhone(patient.getPhone());

        patientRepository.save(patientDb);
    }

    @Override
    public void deleteById(Long id) {
        patientRepository.deleteById(id);
    }
}