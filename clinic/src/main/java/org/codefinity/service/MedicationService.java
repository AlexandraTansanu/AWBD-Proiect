package org.codefinity.service;

//import org.codefinity.models.Appointment;
import org.codefinity.models.Medication;
import org.codefinity.models.Patient;
import org.codefinity.models.Prescription;
import org.codefinity.repository.MedicationRepository;
import org.codefinity.repository.PatientRepository;
import org.codefinity.repository.PrescriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class MedicationService {
    private  MedicationRepository medicationRepository;

    public Medication save(Medication medication) {
        return medicationRepository.save(medication);
    }

    public List<Medication> findAll() {
        return medicationRepository.findAll();
    }

    public List<Medication> findByBrand(String brand) {
        return medicationRepository.findByBrand(brand);
    }
}
