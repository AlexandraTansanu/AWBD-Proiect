package org.codefinity.mapper;

import org.codefinity.dto.*;
import org.codefinity.models.*;
import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = "spring")
public interface MedicationMapper {
    Medication toEntity(MedicationDTO dto);
    MedicationDTO toDto(Medication med);
    List<MedicationDTO> toDtoList(List<Medication> meds);
}