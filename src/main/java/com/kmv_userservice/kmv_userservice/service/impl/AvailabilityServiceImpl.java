package com.kmv_userservice.kmv_userservice.service.impl;

import com.kmv_userservice.kmv_userservice.models.Availability;
import com.kmv_userservice.kmv_userservice.models.Locum;
import com.kmv_userservice.kmv_userservice.repository.AvailabilityRepository;
import com.kmv_userservice.kmv_userservice.repository.LocumRepository;
import com.kmv_userservice.kmv_userservice.service.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvailabilityServiceImpl implements AvailabilityService {

    @Autowired
    private AvailabilityRepository availabilityRepository;

    @Autowired
    private LocumRepository locumRepository;

    @Override
    public Availability saveAvailability(Availability availability) {
        if (availability.getLocum() != null && availability.getLocum().getLocumId() != null) {
            Locum managedLocum = locumRepository.findById(availability.getLocum().getLocumId())
                    .orElseThrow(() -> new RuntimeException("Locum not found with ID: " + availability.getLocum().getLocumId()));
            availability.setLocum(managedLocum);
        } else if (availability.getLocum() != null && availability.getLocum().getLocumId() == null) {
            // Save the transient Locum instance first
            Locum savedLocum = locumRepository.save(availability.getLocum());
            availability.setLocum(savedLocum);
        }
        return availabilityRepository.save(availability);
    }
}
