package com.kmv_userservice.kmv_userservice.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "qualifications")
public class Qualification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer qualification_id;

    @ManyToOne
    @JoinColumn(name = "locum_id", referencedColumnName = "locum_id")
    private Locum locum;

    private String document_type;
    private String document_url;

    // Getters and setters
}
