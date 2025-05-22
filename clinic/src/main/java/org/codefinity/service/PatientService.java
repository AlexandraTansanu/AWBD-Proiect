package org.codefinity.service;

//import org.codefinity.models.Appointment;
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
public class PatientService {
    private PatientRepository patientRepository;

    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    public Optional<Patient> findById(Long id) {
        return patientRepository.findById(id);
    }

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    public void deleteById(Long id) {
        patientRepository.deleteById(id);
    }

  //  public List<Appointment> getUpcomingAppointments(Long patientId) {
  //      return patientRepository.findById(patientId)
  //              .map(p -> p.getAppointments().stream()
  //                     .filter(a -> a.getDateTime().isAfter(LocalDateTime.now()))
  //                      .collect(Collectors.toList()))
  //             .orElseThrow();
  //   }
}