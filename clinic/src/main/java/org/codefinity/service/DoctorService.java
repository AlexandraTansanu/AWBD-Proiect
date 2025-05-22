package org.codefinity.service;

import org.codefinity.models.Clinic;
import org.codefinity.models.Doctor;
import org.codefinity.repository.ClinicRepository;
import org.codefinity.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ClinicRepository clinicRepository;

    public Doctor createDoctor(Doctor doctor, Long clinicId) {
        Clinic clinic = clinicRepository.findById(clinicId).orElseThrow(() -> new RuntimeException("Clinic not found"));
        doctor.setClinic(clinic);
        return doctorRepository.save(doctor);
    }

    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElseThrow(() -> new RuntimeException("Doctor not found"));
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public void deleteDoctorById(Long id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new RuntimeException("Doctor not found"));
        doctorRepository.delete(doctor);
    }

    public Doctor updateDoctor(Doctor updatedDoctor) {
        Doctor existingDoctor = doctorRepository.findById(updatedDoctor.getId())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        existingDoctor.setFirstName(updatedDoctor.getFirstName());
        existingDoctor.setLastName(updatedDoctor.getLastName());
        existingDoctor.setSpecialty(updatedDoctor.getSpecialty());

        if (updatedDoctor.getClinic() != null &&
                (existingDoctor.getClinic() == null ||
                        !existingDoctor.getClinic().getId().equals(updatedDoctor.getClinic().getId()))) {

            if (existingDoctor.getClinic() != null) {
                existingDoctor.getClinic().removeDoctor(existingDoctor);
            }

            Clinic newClinic = updatedDoctor.getClinic();
            newClinic.addDoctor(existingDoctor);
        }

        return doctorRepository.save(existingDoctor);
    }
}
