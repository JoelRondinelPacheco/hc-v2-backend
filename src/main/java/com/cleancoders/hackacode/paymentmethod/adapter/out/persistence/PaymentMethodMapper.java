package com.cleancoders.hackacode.paymentmethod.adapter.out.persistence;

import com.cleancoders.hackacode.common.PersistenceMapper;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.paymentmethod.domain.PaymentMethod;
import org.springframework.beans.factory.annotation.Qualifier;

@PersistenceMapper
@Qualifier("paymentMethodMapper")
public class PaymentMethodMapper implements Mapper<PaymentMethod, PaymentMethodEntity> {

    @Override
    public PaymentMethod entityToDomain(PaymentMethodEntity entity) {
        return PaymentMethod.builder()
                .id(entity.getId())
                .type(entity.getType())
                .interest(entity.getInterest())
                .build();
    }

    @Override
    public PaymentMethodEntity domainToEntity(PaymentMethod domain) {
        return PaymentMethodEntity.builder()
                .type(domain.getType())
                .interest(domain.getInterest())
                .build();
    }
}
