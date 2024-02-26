package com.cleancoders.hackacode.paymentmethod.application.usecases.impl;


import ch.qos.logback.core.joran.action.NewRuleAction;
import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.paymentmethod.application.port.out.PaymentMethodUtilsPort;
import com.cleancoders.hackacode.paymentmethod.application.usecases.PaymentMethodUtils;
import org.springframework.beans.factory.annotation.Autowired;

@UseCase
public class PaymentMethodUtilsImpl implements PaymentMethodUtils {

    @Autowired
    private PaymentMethodUtilsPort paymentMethodUtilsPort;

    @Override
    public void assertExistsById(Long id) {
        if (!this.paymentMethodUtilsPort.existsById(id)) {
            throw new RuntimeException("TODO");
        }
    }
}
