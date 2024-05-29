package com.joelrondinelpacheco.hackacode.paymentmethod.adapter.out.persistence.mapper;

import com.joelrondinelpacheco.hackacode.common.adapter.Mapper;
import com.joelrondinelpacheco.hackacode.paymentmethod.adapter.out.persistence.PaymentMethodEntity;
import com.joelrondinelpacheco.hackacode.paymentmethod.domain.PaymentMethod;

public interface PaymentMethodMapper extends Mapper<PaymentMethod, PaymentMethodEntity> {

    PaymentMethodEntity domainToEntityWithId(PaymentMethod paymentMethod);
}
