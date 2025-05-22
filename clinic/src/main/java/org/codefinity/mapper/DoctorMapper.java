package org.codefinity.mapper;

import org.codefinity.dto.DoctorDTO;
import org.codefinity.models.Clinic;
import org.codefinity.models.Doctor;

public interface DoctorMapper {
    static DoctorDTO toDTO(Doctor doctor) {
        return new DoctorDTO(
                doctor.getId(),
                doctor.getFirstName(),
                doctor.getLastName(),
                doctor.getSpecialty(),
                doctor.getClinic().getId()
        );
    }

    static Doctor toEntity(DoctorDTO dto, Clinic clinic) {
        Doctor doctor = new Doctor();
        doctor.setId(dto.getId());
        doctor.setFirstName(dto.getFirstName());
        doctor.setLastName(dto.getLastName());
        doctor.setSpecialty(dto.getSpecialty());
        doctor.setClinic(clinic);
        return doctor;
    }
}