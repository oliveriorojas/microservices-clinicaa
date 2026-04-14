package com.microservices.prescription.repository;
import com.microservices.prescription.models.Prescription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPrescriptionRepository extends CrudRepository<Prescription, Long> {
}