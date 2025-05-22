package org.codefinity.controller;

import org.codefinity.dto.AppointmentDTO;
import org.codefinity.mapper.AppointmentMapper;
import org.codefinity.models.Appointment;
import org.codefinity.models.Doctor;
import org.codefinity.models.Patient;
import org.codefinity.models.Prescription;
import org.codefinity.service.AppointmentService;
import org.codefinity.service.DoctorService;
import org.codefinity.service.PatientService;
import org.codefinity.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PrescriptionService prescriptionService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public AppointmentDTO createAppointment(@RequestBody AppointmentDTO dto) {
        Doctor doctor = doctorService.getDoctorById(dto.getDoctorId());
        Patient patient = patientService.findById(dto.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        Prescription prescription = dto.getPrescriptionId() != null
                ? prescriptionService.getPrescriptionById(dto.getPrescriptionId())
                : null;

        Appointment appointment = AppointmentMapper.toEntity(dto, doctor, patient, prescription);
        return AppointmentMapper.toDTO(appointmentService.createAppointment(appointment, dto.getDoctorId()));
    }


    @GetMapping("/{id}")
    public AppointmentDTO getAppointment(@PathVariable Long id) {
        return AppointmentMapper.toDTO(appointmentService.getAppointmentById(id));
    }

    @GetMapping
    public List<AppointmentDTO> getAllAppointments() {
        return appointmentService.getAllAppointments().stream()
                .map(AppointmentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointmentById(id);
    }

    @PutMapping("/{id}")
    public AppointmentDTO updateAppointment(@PathVariable Long id, @RequestBody AppointmentDTO dto) {
        Doctor doctor = doctorService.getDoctorById(dto.getDoctorId());
        Patient patient = patientService.findById(dto.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        Prescription prescription = dto.getPrescriptionId() != null
                ? prescriptionService.getPrescriptionById(dto.getPrescriptionId())
                : null;

        Appointment updated = AppointmentMapper.toEntity(dto, doctor, patient, prescription);
        updated.setId(id);
        return AppointmentMapper.toDTO(appointmentService.updateAppointment(updated));
    }
}
