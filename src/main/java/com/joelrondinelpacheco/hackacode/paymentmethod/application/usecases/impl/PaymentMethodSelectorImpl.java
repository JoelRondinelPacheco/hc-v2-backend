package com.joelrondinelpacheco.hackacode.paymentmethod.application.usecases.impl;

import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.paymentmethod.application.port.in.PaymentMethodSelector;
import com.joelrondinelpacheco.hackacode.paymentmethod.application.port.out.PaymentMethodSelectorPort;
import com.joelrondinelpacheco.hackacode.paymentmethod.domain.PaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@UseCase
public class PaymentMethodSelectorImpl implements PaymentMethodSelector {

    @Autowired
    private PaymentMethodSelectorPort paymentMethodSelector;

    @Override
    public PaymentMethod byId(Long id) {
        return this.paymentMethodSelector.byId(id);
    }

    @Override
    public PaymentMethod byName(String name) {
        return this.paymentMethodSelector.byName(name);
    }

    @Override
    public Page<PaymentMethod> all(Pageable pageable) {
        return this.paymentMethodSelector.all(pageable);
    }

    @Override
    public Page<PaymentMethod> getAll(Pageable pageable) {
        return this.paymentMethodSelector.all(pageable);
    }
}
