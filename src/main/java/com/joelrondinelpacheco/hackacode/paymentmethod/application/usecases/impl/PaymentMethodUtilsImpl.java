package com.joelrondinelpacheco.hackacode.paymentmethod.application.usecases.impl;


import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.paymentmethod.application.port.out.PaymentMethodUtilsPort;
import com.joelrondinelpacheco.hackacode.paymentmethod.application.usecases.PaymentMethodUtils;
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

    @Override
    public void assertDoesNotExistsById(Long id) {
        if (this.paymentMethodUtilsPort.existsById(id)) {
            throw new RuntimeException("TODO");
        }
    }

    @Override
    public void assertExistsByName(String name) {
        if (!this.paymentMethodUtilsPort.existsByName(name)) {
            throw new RuntimeException("TODO EX");
        }
    }

    @Override
    public void assertDoesNotExistsByName(String name) {
        if (this.paymentMethodUtilsPort.existsByName(name)) {
            throw new RuntimeException("TODO EX");
        }
    }
}
