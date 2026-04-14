package com.microservices.prescription.dto;
import lombok.Data;

@Data
public class AppointmentDTO {
    private String date;
    private String status;
    private PatientDTO patient;
    private DoctorDTO doctor;
}