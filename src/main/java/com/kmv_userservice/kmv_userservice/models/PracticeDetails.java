package com.kmv_userservice.kmv_userservice.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.Duration;
import java.time.LocalTime;

@Entity
@Table(name = "practice_details")
@Data
public class PracticeDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String practiceName;
    private String practiceType; // NHS, Private
    private String corporateOrIndependent; // Corporate or Independent
    private LocalTime arriveBy;
    private LocalTime leaveAt;
    private Duration lunchDuration;

    @ManyToOne
    @JoinColumn(name = "clinic_id", referencedColumnName = "id")
    private Clinic clinic;
}
