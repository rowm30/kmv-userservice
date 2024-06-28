package com.kmv_userservice.kmv_userservice.service.impl;

import com.kmv_userservice.kmv_userservice.models.Requirement;
import com.kmv_userservice.kmv_userservice.repository.RequirementRepository;
import com.kmv_userservice.kmv_userservice.service.RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequirementServiceImpl implements RequirementService {

    @Autowired
    private RequirementRepository requirementRepository;

    @Override
    public Requirement saveRequirement(Requirement requirement) {
        // Further validation and logic can be added here
        return requirementRepository.save(requirement);
    }
}
