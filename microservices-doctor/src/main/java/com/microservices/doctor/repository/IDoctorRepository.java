package com.microservices.doctor.repository;

import com.microservices.doctor.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDoctorRepository extends JpaRepository<Doctor, Long> {
}