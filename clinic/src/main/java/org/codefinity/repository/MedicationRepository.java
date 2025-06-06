package org.codefinity.repository;

import org.codefinity.models.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicationRepository extends JpaRepository<Medication, Long> {
    List<Medication> findByBrand(String brand);
}
