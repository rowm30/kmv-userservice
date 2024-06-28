package com.kmv_userservice.kmv_userservice.service.impl;

import com.kmv_userservice.kmv_userservice.models.Clinic;
import com.kmv_userservice.kmv_userservice.repository.ClinicRepository;
import com.kmv_userservice.kmv_userservice.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClinicServiceImpl implements ClinicService {
    @Autowired
    private ClinicRepository clinicRepository;

    @Override
    public Clinic registerClinic(Clinic clinic) {
        // Additional logic before saving
        return clinicRepository.save(clinic);
    }
}