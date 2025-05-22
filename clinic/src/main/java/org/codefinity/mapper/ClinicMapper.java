package org.codefinity.mapper;

import org.codefinity.dto.ClinicDTO;
import org.codefinity.models.Clinic;

public interface ClinicMapper {
    static ClinicDTO toDTO(Clinic clinic) {
        return new ClinicDTO(clinic.getId(), clinic.getName(), clinic.getAddress());
    }

    static Clinic toEntity(ClinicDTO dto) {
        Clinic clinic = new Clinic();
        clinic.setId(dto.getId());
        clinic.setName(dto.getName());
        clinic.setAddress(dto.getAddress());
        return clinic;
    }
}
