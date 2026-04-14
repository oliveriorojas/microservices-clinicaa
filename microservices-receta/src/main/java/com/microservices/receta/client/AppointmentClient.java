package com.microservices.prescription.client;
import com.microservices.prescription.dto.AppointmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-appointment", url = "localhost:8080/api/appointment")
public interface AppointmentClient {
    @GetMapping("/detail/{id}")
    AppointmentDTO getAppointmentDetail(@PathVariable("id") Long id);
}