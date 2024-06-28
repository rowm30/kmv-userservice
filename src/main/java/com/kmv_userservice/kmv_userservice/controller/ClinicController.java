package com.kmv_userservice.kmv_userservice.controller;


import com.kmv_userservice.kmv_userservice.models.Clinic;
import com.kmv_userservice.kmv_userservice.models.ClinicAddress;
import com.kmv_userservice.kmv_userservice.models.PaymentMethod;
import com.kmv_userservice.kmv_userservice.models.PracticeDetails;
import com.kmv_userservice.kmv_userservice.service.ClinicAddressService;
import com.kmv_userservice.kmv_userservice.service.ClinicService;
import com.kmv_userservice.kmv_userservice.service.PaymentMethodService;
import com.kmv_userservice.kmv_userservice.service.PracticeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}, allowedHeaders = "*", allowCredentials = "true")
@RestController
public class ClinicController {

    @Autowired
    private ClinicService clinicService; // This is the interface for the service class


    @Autowired
    private ClinicAddressService clinicAddressService;

    @Autowired
    private PracticeDetailsService practiceDetailsService;

    @Autowired
    private PaymentMethodService paymentMethodService;

    @PostMapping("/clinicaddresses")
    public ResponseEntity<ClinicAddress> createAddress(@RequestBody ClinicAddress address) {
        ClinicAddress savedAddress = clinicAddressService.saveAddress(address);
        return ResponseEntity.ok(savedAddress);
    }

    @PostMapping("/registerclinic")
    public ResponseEntity<Clinic> registerClinic(@RequestBody Clinic clinic) {
        Clinic registeredClinic = clinicService.registerClinic(clinic);
        return ResponseEntity.ok(registeredClinic);
    }

    @PostMapping("/practicedetails")
    public ResponseEntity<PracticeDetails> addPracticeDetails(@RequestBody PracticeDetails practiceDetails) {
        PracticeDetails savedDetails = practiceDetailsService.savePracticeDetails(practiceDetails);
        return ResponseEntity.ok(savedDetails);
    }

    @PostMapping("/paymentmethods")
    public ResponseEntity<PaymentMethod> addPaymentMethod(@RequestBody PaymentMethod paymentMethod) {
        PaymentMethod savedMethod = paymentMethodService.savePaymentMethod(paymentMethod);
        return ResponseEntity.ok(savedMethod);
    }
}
