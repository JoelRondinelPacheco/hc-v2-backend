package com.joelrondinelpacheco.hackacode.paymentmethod.adapter.out.persistence;

import com.joelrondinelpacheco.hackacode.common.PersistenceAdapter;
import com.joelrondinelpacheco.hackacode.common.domain.EntityNotFoundException;
import com.joelrondinelpacheco.hackacode.paymentmethod.adapter.out.persistence.mapper.PaymentMethodMapper;
import com.joelrondinelpacheco.hackacode.paymentmethod.application.port.out.PaymentMethodSelectorPort;
import com.joelrondinelpacheco.hackacode.paymentmethod.domain.PaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@PersistenceAdapter
public class PaymentMethodSelectorMySQLPersistenceAdapter implements PaymentMethodSelectorPort {

    @Autowired
    private PaymentMethodMySQLRepository paymentMethodRepository;

    @Autowired
    private PaymentMethodMapper mapper;


    @Override
    public PaymentMethod byId(Long id) {
        PaymentMethodEntity paymentMethodEntity = this.paymentMethodRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Payment method with ID: " + id + ", not found.")
        );
        return this.mapper.entityToDomain(paymentMethodEntity);
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
        return this.paymentMethodRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Payment method with ID: " + id + ", not found.")
        );
    }
}
