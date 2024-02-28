package com.cleancoders.hackacode.paymentmethod.adapter.out.persistence;

import com.cleancoders.hackacode.common.PersistenceAdapter;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.paymentmethod.application.port.out.PaymentMethodSelectorPort;
import com.cleancoders.hackacode.paymentmethod.domain.PaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@PersistenceAdapter
public class PaymentMethodSelectorMySQLPersistenceAdapter implements PaymentMethodSelectorPort {

    @Autowired
    private PaymentMethodMySQLRepository paymentMethodRepository;

    @Autowired
    @Qualifier("paymentMethodMapper")
    private Mapper<PaymentMethod, PaymentMethodEntity> mapper;


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
        return this.paymentMethodRepository.findAll(pageable).map(this.mapper::entityToDomain);
    }

    public PaymentMethodEntity entityById(Long id) {
        return this.paymentMethodRepository.findById(id).orElseThrow();
    }
}
