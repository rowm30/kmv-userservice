package com.kmv_userservice.kmv_userservice.service.impl;

import com.kmv_userservice.kmv_userservice.models.PaymentMethod;
import com.kmv_userservice.kmv_userservice.repository.PaymentMethodRepository;
import com.kmv_userservice.kmv_userservice.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {
    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @Override
    public PaymentMethod savePaymentMethod(PaymentMethod paymentMethod) {
        return paymentMethodRepository.save(paymentMethod);
    }
}