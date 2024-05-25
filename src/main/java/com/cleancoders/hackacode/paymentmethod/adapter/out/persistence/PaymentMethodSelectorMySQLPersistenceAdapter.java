package com.cleancoders.hackacode.paymentmethod.adapter.out.persistence;

import com.cleancoders.hackacode.common.PersistenceAdapter;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.paymentmethod.adapter.out.persistence.mapper.PaymentMethodMapper;
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
    private PaymentMethodMapper mapper;


    @Override
    public PaymentMethod byId(Long id) {
        System.out.println(id);
        PaymentMethodEntity paymentMethodEntity = this.paymentMethodRepository.findById(id).orElseThrow(() -> new RuntimeException("no existe payment"));
        System.out.println(paymentMethodEntity.getId());
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
        return this.paymentMethodRepository.findById(id).orElseThrow();
    }
}
