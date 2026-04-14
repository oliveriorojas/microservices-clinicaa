package com.microservices.prescription.controller;

import com.microservices.prescription.client.AppointmentClient;
import com.microservices.prescription.dto.AppointmentDTO;
import com.microservices.prescription.http.response.PrescriptionDetailResponse;
import com.microservices.prescription.models.Prescription;
import com.microservices.prescription.services.IPrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prescription")
public class PrescriptionController {

    @Autowired
    private IPrescriptionService prescriptionService;

    @Autowired
    private AppointmentClient appointmentClient;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Prescription prescription) {
        prescriptionService.save(prescription);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(prescriptionService.findAll());
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> getDetail(@PathVariable Long id) {
        Prescription prescription = prescriptionService.findById(id);
        AppointmentDTO appointment = appointmentClient.getAppointmentDetail(prescription.getAppointmentId());

        PrescriptionDetailResponse response = PrescriptionDetailResponse.builder()
                .description(prescription.getDescription())
                .observations(prescription.getObservations())
                .appointment(appointment)
                .build();

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        prescriptionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Prescription prescription) {
        prescriptionService.update(id, prescription);
        return ResponseEntity.ok("Receta actualizada correctamente");
    }
}