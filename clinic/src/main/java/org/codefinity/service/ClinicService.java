package org.codefinity.service;

import org.codefinity.models.Clinic;
import org.codefinity.repository.ClinicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicService {

    @Autowired
    private ClinicRepository clinicRepository;

    public Clinic createClinic(Clinic clinic) {
        if (clinicRepository.findByName(clinic.getName()).isPresent()) {
            throw new IllegalArgumentException("Clinic name already exists");
        }
        return clinicRepository.save(clinic);
    }

    public Clinic getClinicById(Long id) {
        return clinicRepository.findById(id).orElseThrow(() -> new RuntimeException("Clinic not found"));
    }

    public List<Clinic> getAllClinics() {
        return clinicRepository.findAll();
    }

    public void deleteClinicById(Long id) {
        Clinic clinic = clinicRepository.findById(id).orElseThrow(() -> new RuntimeException("Clinic not found"));
        clinicRepository.delete(clinic);
    }

    public Clinic updateClinic(Long id, Clinic clinicUpdate) {
        Clinic existingClinic = clinicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clinic not found"));

        existingClinic.setName(clinicUpdate.getName());
        existingClinic.setAddress(clinicUpdate.getAddress());

        return clinicRepository.save(existingClinic);
    }

}

