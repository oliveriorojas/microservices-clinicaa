package com.microservices.paciente.controllers;

import com.microservices.paciente.models.Patient;
import com.microservices.paciente.services.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    private IPatientService patientService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void savePatient(@RequestBody Patient patient) {
        patientService.save(patient);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(patientService.findAll());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
        try {
            patientService.update(id, patient);
            return ResponseEntity.status(HttpStatus.OK).body("Paciente actualizado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se pudo encontrar el paciente con ID: " + id);
        }
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(patientService.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Long id) {
        try {
            patientService.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // 204 No Content es el estándar para deletes exitosos
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el paciente para eliminar");
        }
    }
}