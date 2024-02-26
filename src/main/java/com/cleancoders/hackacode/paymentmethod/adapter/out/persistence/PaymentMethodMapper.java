package com.cleancoders.hackacode.paymentmethod.adapter.out.persistence;

import com.cleancoders.hackacode.common.PersistenceMapper;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.paymentmethod.domain.PaymentMethod;
import org.springframework.beans.factory.annotation.Qualifier;

@PersistenceMapper
@Qualifier("paymentMethodMapper")
public class PaymentMethodMapper implements Mapper<PaymentMethod, PaymentMethodEntity> {

    @Override
    public PaymentMethod entityToDomain(PaymentMethodEntity paymentMethodEntity) {
        return PaymentMethod.builder()
                .id(paymentMethodEntity.getId())
                .type(paymentMethodEntity.getType())
                .interest(paymentMethodEntity.getInterest())
                .build();
    }

    @Override
    public PaymentMethodEntity domainToEntity(PaymentMethod paymentMethod) {
        return PaymentMethodEntity.builder()
                .type(paymentMethod.getType())
                .interest(paymentMethod.getInterest())
                .build();
    }
}
