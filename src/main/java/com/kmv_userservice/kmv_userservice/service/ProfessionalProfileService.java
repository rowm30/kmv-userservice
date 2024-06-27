package com.kmv_userservice.kmv_userservice.service;


import com.kmv_userservice.kmv_userservice.models.ProfessionalProfile;

public interface ProfessionalProfileService {
    ProfessionalProfile saveProfile(ProfessionalProfile profile);
    ProfessionalProfile getProfileById(Integer id);
}