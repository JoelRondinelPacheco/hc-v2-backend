package com.joelrondinelpacheco.hackacode.paymentmethod.application.port.out;

import com.joelrondinelpacheco.hackacode.paymentmethod.domain.PaymentMethod;

public interface PaymentMethodPersistencePort {
    PaymentMethod newPaymentMethod(PaymentMethod paymentMethod);

    PaymentMethod edit(PaymentMethod body);
}
