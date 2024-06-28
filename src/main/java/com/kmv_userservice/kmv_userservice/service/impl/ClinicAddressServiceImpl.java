package com.kmv_userservice.kmv_userservice.service.impl;

import com.kmv_userservice.kmv_userservice.models.Clinic;
import com.kmv_userservice.kmv_userservice.models.ClinicAddress;
import com.kmv_userservice.kmv_userservice.repository.ClinicAddressRepository;
import com.kmv_userservice.kmv_userservice.repository.ClinicRepository;
import com.kmv_userservice.kmv_userservice.service.ClinicAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClinicAddressServiceImpl implements ClinicAddressService {

    @Autowired
    private ClinicAddressRepository clinicAddressRepository;

    @Autowired
    private ClinicRepository clinicRepository;

    @Override
    public ClinicAddress saveAddress(ClinicAddress address) {
        if (address.getClinic() != null && address.getClinic().getId() != null) {
            Clinic managedClinic = clinicRepository.findById(address.getClinic().getId())
                    .orElseThrow(() -> new RuntimeException("Clinic not found with ID: " + address.getClinic().getId()));
            address.setClinic(managedClinic);
        } else if (address.getClinic() != null && address.getClinic().getId() == null) {
            // Save the transient Clinic instance first
            Clinic savedClinic = clinicRepository.save(address.getClinic());
            address.setClinic(savedClinic);
        }
        return clinicAddressRepository.save(address);
    }
}
