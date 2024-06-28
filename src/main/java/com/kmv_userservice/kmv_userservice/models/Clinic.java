package com.kmv_userservice.kmv_userservice.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "clinics")
@Data
public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String mobilePhone;

    @Column(nullable = false)
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "practice_details_id", referencedColumnName = "id")
    private PracticeDetails practiceDetails;

    @OneToMany(mappedBy = "clinic")
    private List<PaymentMethod> paymentMethods;
}
