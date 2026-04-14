package com.microservices.prescription.services;

import com.microservices.prescription.models.Prescription;
import com.microservices.prescription.repository.IPrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PrescriptionServiceImpl implements IPrescriptionService {

    @Autowired
    private IPrescriptionRepository prescriptionRepository;

    @Override
    public List<Prescription> findAll() {
        return (List<Prescription>) prescriptionRepository.findAll();
    }

    @Override
    public Prescription findById(Long id) {
        return prescriptionRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Prescription prescription) {
        prescriptionRepository.save(prescription);
    }

    @Override
    public void deleteById(Long id) {
        prescriptionRepository.deleteById(id);
    }

    @Override
    public void update(Long id, Prescription prescription) {
        Prescription prescriptionDb = prescriptionRepository.findById(id).orElseThrow();
        prescriptionDb.setDescription(prescription.getDescription());
        prescriptionDb.setObservations(prescription.getObservations());
        prescriptionDb.setAppointmentId(prescription.getAppointmentId());

        prescriptionRepository.save(prescriptionDb);
    }
}