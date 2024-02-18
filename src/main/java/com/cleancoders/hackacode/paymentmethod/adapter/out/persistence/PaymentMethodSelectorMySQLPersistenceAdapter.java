package com.cleancoders.hackacode.paymentmethod.adapter.out.persistence;

import com.cleancoders.hackacode.common.PersistenceAdapter;
import com.cleancoders.hackacode.paymentmethod.application.port.out.PaymentMethodSelectorPort;
import com.cleancoders.hackacode.paymentmethod.domain.PaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@PersistenceAdapter
public class PaymentMethodSelectorMySQLPersistenceAdapter implements PaymentMethodSelectorPort {

    @Autowired
    private PaymentMethodMySQLRepository paymentMethodRepository;

    @Override
    public PaymentMethod byId(Long id) {
        return null;
    }

    @Override
    public PaymentMethod byName(String name) {
        return null;
    }

    @Override
    public Page<PaymentMethod> all(Pageable pageable) {
        return this.paymentMethodRepository.findAll(pageable).map(PaymentMethodMapper::entityToDomain);
    }
}
