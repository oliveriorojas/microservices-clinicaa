package com.microservices.prescription.http.response;

import com.microservices.prescription.dto.AppointmentDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PrescriptionDetailResponse {

    private String description;
    private String observations;
    private AppointmentDTO appointment;
}