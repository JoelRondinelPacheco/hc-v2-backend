package com.joelrondinelpacheco.hackacode.paymentmethod.application.port.in;

import com.joelrondinelpacheco.hackacode.paymentmethod.domain.PaymentMethod;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PaymentMethodSelector {
    PaymentMethod byId(Long id);
    PaymentMethod byName(String name);
    Page<PaymentMethod> all(Pageable pageable);
    Page<PaymentMethod> getAll(Pageable pageable);
}
