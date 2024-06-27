package com.kmv_userservice.kmv_userservice.models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "professional_profiles")
public class ProfessionalProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer profile_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", referencedColumnName = "roleId")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "locum_id", referencedColumnName = "locum_id")
    private Locum locum;

    private String biography;
    private String gdc_number;
    private String reviews;
    @Column(name = "professional_references", length = 255) // Renamed to avoid reserved keyword
    private String professionalReferences;

    // Getters and setters
}
