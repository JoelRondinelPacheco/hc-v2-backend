package com.cleancoders.hackacode.paymentmethod.application.port.out;

import com.cleancoders.hackacode.paymentmethod.domain.PaymentMethod;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PaymentMethodSelectorPort {
    PaymentMethod byId(Long id);
    PaymentMethod byName(String name);
    Page<PaymentMethod> all(Pageable pageable);
}
