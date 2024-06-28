package com.kmv_userservice.kmv_userservice.service.impl;

import com.kmv_userservice.kmv_userservice.models.PracticeDetails;
import com.kmv_userservice.kmv_userservice.repository.PracticeDetailsRepository;
import com.kmv_userservice.kmv_userservice.service.PracticeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PracticeDetailsServiceImpl implements PracticeDetailsService {
    @Autowired
    private PracticeDetailsRepository practiceDetailsRepository;

    @Override
    public PracticeDetails savePracticeDetails(PracticeDetails practiceDetails) {
        return practiceDetailsRepository.save(practiceDetails);
    }
}