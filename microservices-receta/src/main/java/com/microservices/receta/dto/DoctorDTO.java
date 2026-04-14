package com.microservices.prescription.dto;

import lombok.Data;

@Data
public class DoctorDTO {
    private Long id;
    private String firstName;
    private String specialty;
}