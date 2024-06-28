package com.kmv_userservice.kmv_userservice.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer address_id;

    @ManyToOne
    @JoinColumn(name = "locum_id", referencedColumnName = "locum_id")
    private Locum locum;

    private String address_line1;
    private String address_line2;
    private String town;
    private String postcode;

    // Getters and setters
}