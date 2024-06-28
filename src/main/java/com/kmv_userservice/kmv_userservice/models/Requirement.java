package com.kmv_userservice.kmv_userservice.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Entity
@Table(name = "requirements")
@Data
public class Requirement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "clinic_id", referencedColumnName = "id")
    private Clinic clinic;

    private String locumType; // Nurse, Hygienist, Dentist, or General Locum
    private LocalTime startTime;
    private LocalTime endTime;
    private DayOfWeek day;
    private double hourlyRate;
}
