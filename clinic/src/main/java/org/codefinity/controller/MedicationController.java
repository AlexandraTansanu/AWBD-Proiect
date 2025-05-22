package org.codefinity.controller;

import lombok.RequiredArgsConstructor;
import org.codefinity.dto.*;
import org.codefinity.mapper.*;
import org.codefinity.models.*;
import org.codefinity.models.Medication;
import org.codefinity.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/medications")
@RequiredArgsConstructor
public class MedicationController {
    private MedicationService medicationService;
    private MedicationMapper medicationMapper;

    @PostMapping
    public ResponseEntity<MedicationDTO> create(@RequestBody MedicationDTO dto) {
        Medication saved = medicationService.save(medicationMapper.toEntity(dto));
        return ResponseEntity.ok(medicationMapper.toDto(saved));
    }

    @GetMapping
    public List<MedicationDTO> getAll(@RequestParam(required = false) String brand) {
        return medicationMapper.toDtoList(
                (brand == null) ? medicationService.findAll() : medicationService.findByBrand(brand));
    }
}