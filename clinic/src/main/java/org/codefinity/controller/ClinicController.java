package org.codefinity.controller;

import org.codefinity.dto.ClinicDTO;
import org.codefinity.mapper.ClinicMapper;
import org.codefinity.models.Clinic;
import org.codefinity.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/clinics")
public class ClinicController {
    @Autowired
    private ClinicService clinicService;

    @PostMapping
    public ClinicDTO createClinic(@RequestBody ClinicDTO dto) {
        Clinic clinic = ClinicMapper.toEntity(dto);
        return ClinicMapper.toDTO(clinicService.createClinic(clinic));
    }

    @GetMapping("/{id}")
    public ClinicDTO getClinic(@PathVariable Long id) {
        return ClinicMapper.toDTO(clinicService.getClinicById(id));
    }

    @GetMapping
    public List<ClinicDTO> getAllClinics() {
        return clinicService.getAllClinics().stream()
                .map(ClinicMapper::toDTO)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void deleteClinic(@PathVariable Long id) {
        clinicService.deleteClinicById(id);
    }

    @PutMapping("/{id}")
    public ClinicDTO updateClinic(@PathVariable Long id, @RequestBody ClinicDTO dto) {
        Clinic clinic = ClinicMapper.toEntity(dto);
        clinic.setId(id);
        return ClinicMapper.toDTO(clinicService.updateClinic(id, clinic));
    }
}
