package com.kmv_userservice.kmv_userservice.service.impl;

import com.kmv_userservice.kmv_userservice.models.Financial;
import com.kmv_userservice.kmv_userservice.models.Locum;
import com.kmv_userservice.kmv_userservice.repository.FinancialRepository;
import com.kmv_userservice.kmv_userservice.repository.LocumRepository;
import com.kmv_userservice.kmv_userservice.service.FinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinancialServiceImpl implements FinancialService {

    @Autowired
    private FinancialRepository financialRepository;

    @Autowired
    private LocumRepository locumRepository;

    @Override
    public Financial saveFinancial(Financial financial) {
        if (financial.getLocum() != null && financial.getLocum().getLocumId() != null) {
            Locum managedLocum = locumRepository.findById(financial.getLocum().getLocumId())
                    .orElseThrow(() -> new RuntimeException("Locum not found with ID: " + financial.getLocum().getLocumId()));
            financial.setLocum(managedLocum);
        } else if (financial.getLocum() != null && financial.getLocum().getLocumId() == null) {
            // Save the transient Locum instance first
            Locum savedLocum = locumRepository.save(financial.getLocum());
            financial.setLocum(savedLocum);
        }
        return financialRepository.save(financial);
    }
}
