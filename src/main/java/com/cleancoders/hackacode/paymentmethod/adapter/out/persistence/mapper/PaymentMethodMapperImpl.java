package com.cleancoders.hackacode.paymentmethod.adapter.out.persistence.mapper;

import com.cleancoders.hackacode.common.PersistenceMapper;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.paymentmethod.adapter.out.persistence.PaymentMethodEntity;
import com.cleancoders.hackacode.paymentmethod.domain.PaymentMethod;
import org.springframework.beans.factory.annotation.Qualifier;

@PersistenceMapper
public class PaymentMethodMapperImpl implements PaymentMethodMapper {

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

    @Override
    public PaymentMethodEntity domainToEntityWithId(PaymentMethod paymentMethod) {
        PaymentMethodEntity paymentMethodEntity = this.domainToEntity(paymentMethod);
        paymentMethodEntity.setId(paymentMethod.getId());
        return paymentMethodEntity;
    }
}
