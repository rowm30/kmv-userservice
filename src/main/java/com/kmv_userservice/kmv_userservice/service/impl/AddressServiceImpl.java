package com.kmv_userservice.kmv_userservice.service.impl;

import com.kmv_userservice.kmv_userservice.models.Address;
import com.kmv_userservice.kmv_userservice.models.Locum;
import com.kmv_userservice.kmv_userservice.repository.AddressRepository;
import com.kmv_userservice.kmv_userservice.repository.LocumRepository;
import com.kmv_userservice.kmv_userservice.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private LocumRepository locumRepository;

    @Override
    public Address saveAddress(Address address) {
        if (address.getLocum() != null && address.getLocum().getLocumId() != null) {
            Locum managedLocum = locumRepository.findById(address.getLocum().getLocumId())
                    .orElseThrow(() -> new RuntimeException("Locum not found with ID: " + address.getLocum().getLocumId()));
            managedLocum.getFirstName(); // Ensure lazy loading is initialized
            address.setLocum(managedLocum);
        }
        return addressRepository.save(address);
    }
}
