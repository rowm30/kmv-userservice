package com.kmv_userservice.kmv_userservice.models;



import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "locums")
public class Locum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer locum_id;

    @Column(nullable = false)
    private String first_name;

    @Column(nullable = false)
    private String last_name;

    @Column(nullable = false, unique = true)
    private String email_address;

    @Column(nullable = false, unique = true)
    private String mobile_phone_number;

    @Column(nullable = false)
    private String password;

    private String profile_photo;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime created_at;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime updated_at;

}
