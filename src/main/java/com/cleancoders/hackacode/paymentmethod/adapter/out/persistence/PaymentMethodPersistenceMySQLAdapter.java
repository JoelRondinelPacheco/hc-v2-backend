package com.cleancoders.hackacode.paymentmethod.adapter.out.persistence;

import com.cleancoders.hackacode.common.PersistenceAdapter;
import com.cleancoders.hackacode.paymentmethod.adapter.out.persistence.mapper.PaymentMethodMapper;
import com.cleancoders.hackacode.paymentmethod.application.port.out.PaymentMethodPersistencePort;
import com.cleancoders.hackacode.paymentmethod.domain.PaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;

@PersistenceAdapter
public class PaymentMethodPersistenceMySQLAdapter implements PaymentMethodPersistencePort {

    @Autowired
    private PaymentMethodMySQLRepository paymentMethodMySQLRepository;

    @Autowired
    private PaymentMethodMapper mapper;

    @Override
    public PaymentMethod newPaymentMethod(PaymentMethod paymentMethod) {
        PaymentMethodEntity paymentMethodEntity = this.paymentMethodMySQLRepository.save(this.mapper.domainToEntity(paymentMethod));

        PaymentMethod paymentMethodSaved = this.mapper.entityToDomain(paymentMethodEntity);
        paymentMethodSaved.setId(paymentMethodEntity.getId());

        return paymentMethodSaved;
    }

    @Override
    public PaymentMethod edit(PaymentMethod body) {
        PaymentMethodEntity paymentMethodEntity = this.mapper.domainToEntity(body);
        paymentMethodEntity.setId(body.getId());

        return this.mapper.entityToDomain(this.paymentMethodMySQLRepository.save(paymentMethodEntity));
    }
}
