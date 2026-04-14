package com.microservices.doctor.controllers;

import com.microservices.doctor.models.Doctor;
import com.microservices.doctor.services.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

    @Autowired
    private IDoctorService doctorService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveDoctor(@RequestBody Doctor doctor) {
        doctorService.save(doctor);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(doctorService.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(doctorService.findById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Doctor doctor) {
        doctorService.update(id, doctor);
        return ResponseEntity.ok("Doctor actualizado");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        doctorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}