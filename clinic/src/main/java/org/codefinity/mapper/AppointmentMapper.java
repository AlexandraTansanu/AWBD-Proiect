package org.codefinity.mapper;

import org.codefinity.dto.AppointmentDTO;
import org.codefinity.models.Appointment;
import org.codefinity.models.Doctor;
import org.codefinity.models.Patient;
import org.codefinity.models.Prescription;

public interface AppointmentMapper {
    static AppointmentDTO toDTO(Appointment appointment) {
        return new AppointmentDTO(
                appointment.getId(),
                appointment.getDoctor().getId(),
                appointment.getPatient().getId(),
                appointment.getStartDate(),
                appointment.getEndDate(),
                appointment.getPrescription() != null ? appointment.getPrescription().getId() : null,
                appointment.getComments()
        );
    }

    static Appointment toEntity(AppointmentDTO dto, Doctor doctor, Patient patient, Prescription prescription) {
        Appointment appointment = new Appointment();
        appointment.setId(dto.getId());
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setStartDate(dto.getStartDate());
        appointment.setEndDate(dto.getEndDate());
        appointment.setPrescription(prescription);
        appointment.setComments(dto.getComments());
        return appointment;
    }
}

