package com.cleancoders.hackacode.paymentmethod.adapter.out.persistence.mapper;

import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.paymentmethod.adapter.out.persistence.PaymentMethodEntity;
import com.cleancoders.hackacode.paymentmethod.domain.PaymentMethod;

public interface PaymentMethodMapper extends Mapper<PaymentMethod, PaymentMethodEntity> {

    PaymentMethodEntity domainToEntityWithId(PaymentMethod paymentMethod);
}
