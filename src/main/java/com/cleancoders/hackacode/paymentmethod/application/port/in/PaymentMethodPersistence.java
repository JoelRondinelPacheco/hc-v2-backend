package com.cleancoders.hackacode.paymentmethod.application.port.in;

import com.cleancoders.hackacode.paymentmethod.application.dto.NewPaymentMethodDTO;
import com.cleancoders.hackacode.paymentmethod.domain.PaymentMethod;

public interface PaymentMethodPersistence {
    PaymentMethod newPaymentMethod(NewPaymentMethodDTO paymentMethodDTO);

    PaymentMethod edit(PaymentMethod body);
}
