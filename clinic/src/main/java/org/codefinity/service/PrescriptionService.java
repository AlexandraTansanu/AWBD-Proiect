package org.codefinity.service;

//import org.codefinity.models.Appointment;
import org.codefinity.models.Doctor;
import org.codefinity.models.Medication;
import org.codefinity.models.Patient;
import org.codefinity.models.Prescription;
import org.codefinity.repository.MedicationRepository;
import org.codefinity.repository.PatientRepository;
import org.codefinity.repository.PrescriptionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PrescriptionService {
    private PrescriptionRepository prescriptionRepository;

    public Prescription save(Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }

    public List<Prescription> findAll() {
        return prescriptionRepository.findAll();
    }

    public Prescription getPrescriptionById(Long id) {
        return prescriptionRepository.findById(id).orElseThrow(() -> new RuntimeException("Prescription not found"));
    }
}
