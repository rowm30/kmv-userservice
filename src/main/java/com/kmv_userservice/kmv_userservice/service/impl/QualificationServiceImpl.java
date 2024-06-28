package com.kmv_userservice.kmv_userservice.service.impl;

import com.kmv_userservice.kmv_userservice.models.Locum;
import com.kmv_userservice.kmv_userservice.models.Qualification;
import com.kmv_userservice.kmv_userservice.repository.LocumRepository;
import com.kmv_userservice.kmv_userservice.repository.QualificationRepository;
import com.kmv_userservice.kmv_userservice.service.QualificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QualificationServiceImpl implements QualificationService {

    @Autowired
    private QualificationRepository qualificationRepository;

    @Autowired
    private LocumRepository locumRepository;

    @Override
    public Qualification saveQualification(Qualification qualification) {
        if (qualification.getLocum() != null && qualification.getLocum().getLocumId() != null) {
            Locum managedLocum = locumRepository.findById(qualification.getLocum().getLocumId())
                    .orElseThrow(() -> new RuntimeException("Locum not found with ID: " + qualification.getLocum().getLocumId()));
            qualification.setLocum(managedLocum);
        } else if (qualification.getLocum() != null && qualification.getLocum().getLocumId() == null) {
            // Save the transient Locum instance first
            Locum savedLocum = locumRepository.save(qualification.getLocum());
            qualification.setLocum(savedLocum);
        }
        return qualificationRepository.save(qualification);
    }
}
