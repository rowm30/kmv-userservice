package com.kmv_userservice.kmv_userservice.service.impl;


import com.kmv_userservice.kmv_userservice.models.Locum;
import com.kmv_userservice.kmv_userservice.repository.LocumRepository;
import com.kmv_userservice.kmv_userservice.service.LocumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocumServiceImpl implements LocumService {

    @Autowired
    private LocumRepository locumRepository;

    @Override
    public Locum saveLocum(Locum locum) {
        // Here you can add additional business logic before saving the locum
        return locumRepository.save(locum);
    }
}
