package org.codefinity.mapper;

import org.codefinity.dto.*;
import org.codefinity.models.*;
import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PrescriptionMapper {
    Patient toEntity(PatientRequestDTO dto);
    PatientResponseDTO toDto(Patient entity);
    List<PatientResponseDTO> toDtoList(List<Patient> entities);
}