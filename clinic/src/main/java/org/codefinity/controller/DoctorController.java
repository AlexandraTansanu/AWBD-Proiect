package org.codefinity.controller;

import org.codefinity.dto.DoctorDTO;
import org.codefinity.mapper.DoctorMapper;
import org.codefinity.models.Doctor;
import org.codefinity.service.ClinicService;
import org.codefinity.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private ClinicService clinicService;

    @PostMapping
    public DoctorDTO createDoctor(@RequestBody DoctorDTO dto) {
        Doctor doctor = DoctorMapper.toEntity(dto, clinicService.getClinicById(dto.getClinicId()));
        return DoctorMapper.toDTO(doctorService.createDoctor(doctor, dto.getClinicId()));
    }

    @GetMapping("/{id}")
    public DoctorDTO getDoctor(@PathVariable Long id) {
        return DoctorMapper.toDTO(doctorService.getDoctorById(id));
    }

    @GetMapping
    public List<DoctorDTO> getAllDoctors() {
        return doctorService.getAllDoctors().stream()
                .map(DoctorMapper::toDTO)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctorById(id);
    }

    @PutMapping("/{id}")
    public DoctorDTO updateDoctor(@PathVariable Long id, @RequestBody DoctorDTO dto) {
        Doctor doctor = DoctorMapper.toEntity(dto, clinicService.getClinicById(dto.getClinicId()));
        doctor.setId(id);
        return DoctorMapper.toDTO(doctorService.updateDoctor(doctor));
    }
}
