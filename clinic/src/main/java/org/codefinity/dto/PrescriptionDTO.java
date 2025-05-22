package org.codefinity.dto;

import lombok.*;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PrescriptionDTO {
    private Long id;
    private String comments;
    private Long appointmentId;
    private List<Long> medicationIds;
}
