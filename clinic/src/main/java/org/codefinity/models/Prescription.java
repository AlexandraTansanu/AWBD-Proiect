package org.codefinity.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comments;

//    @OneToOne
//    @JoinColumn(name = "appointment_id", nullable = false)
//    private Appointment appointment;

    @ManyToMany
    @JoinTable(name = "prescription_medication",
            joinColumns = @JoinColumn(name = "prescription_id"),
            inverseJoinColumns = @JoinColumn(name = "medication_id"))
    private Set<Medication> medications = new HashSet<>();
}
