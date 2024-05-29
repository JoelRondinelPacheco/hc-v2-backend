package com.joelrondinelpacheco.hackacode.paymentmethod.application.port.in;

import com.joelrondinelpacheco.hackacode.paymentmethod.application.dto.NewPaymentMethodDTO;
import com.joelrondinelpacheco.hackacode.paymentmethod.domain.PaymentMethod;

public interface PaymentMethodPersistence {
    PaymentMethod newPaymentMethod(NewPaymentMethodDTO paymentMethodDTO);

    PaymentMethod edit(PaymentMethod body);
}
