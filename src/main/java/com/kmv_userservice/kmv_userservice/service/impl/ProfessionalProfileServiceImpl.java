package com.kmv_userservice.kmv_userservice.service.impl;


import com.kmv_userservice.kmv_userservice.models.ProfessionalProfile;
import com.kmv_userservice.kmv_userservice.repository.ProfessionalProfileRepository;
import com.kmv_userservice.kmv_userservice.service.ProfessionalProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessionalProfileServiceImpl implements ProfessionalProfileService {

    @Autowired
    private ProfessionalProfileRepository repository;

    @Override
    public ProfessionalProfile saveProfile(ProfessionalProfile profile) {
        return repository.save(profile);
    }

    @Override
    public ProfessionalProfile getProfileById(Integer id) {
        return repository.findById(id).orElse(null);
    }
}