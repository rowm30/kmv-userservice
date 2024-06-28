package com.kmv_userservice.kmv_userservice.models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "availability")
public class Availability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer availability_id;

    @ManyToOne
    @JoinColumn(name = "locum_id", referencedColumnName = "locum_id")
    private Locum locum;

    private String availability_days;
    private String availability_type;
    private String practice_type_preference;
    private String work_environment_preference;
    private Integer distance_willing_to_travel;

    // Getters and setters
}
