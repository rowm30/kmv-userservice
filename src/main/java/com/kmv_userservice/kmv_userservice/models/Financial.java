package com.kmv_userservice.kmv_userservice.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "financials")
public class Financial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer financial_id;

    @ManyToOne
    @JoinColumn(name = "locum_id", referencedColumnName = "locum_id")
    private Locum locum;

    private Integer hourly_rate_id;
    private String stripe_account_id;

    // Getters and setters
}
