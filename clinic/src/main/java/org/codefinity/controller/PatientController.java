package org.codefinity.controller;

import lombok.RequiredArgsConstructor;
import org.codefinity.dto.*;
import org.codefinity.mapper.*;
import org.codefinity.models.*;
import org.codefinity.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {
    private PatientService patientService;
    private PatientMapper patientMapper;

    @PostMapping
    public ResponseEntity<PatientResponseDTO> create(@RequestBody PatientRequestDTO dto) {
        Patient saved = patientService.save(patientMapper.toEntity(dto));
        return ResponseEntity.ok(patientMapper.toDto(saved));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientResponseDTO> get(@PathVariable Long id) {
        return patientService.findById(id)
                .map(patientMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<PatientResponseDTO> getAll() {
        return patientMapper.toDtoList(patientService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        patientService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}