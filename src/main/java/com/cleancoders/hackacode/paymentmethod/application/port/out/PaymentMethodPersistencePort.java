package com.cleancoders.hackacode.paymentmethod.application.port.out;

import com.cleancoders.hackacode.paymentmethod.application.dto.NewPaymentMethodDTO;
import com.cleancoders.hackacode.paymentmethod.domain.PaymentMethod;

public interface PaymentMethodPersistencePort {
    PaymentMethod newPaymentMethod(PaymentMethod paymentMethod);

    PaymentMethod edit(PaymentMethod body);
}
