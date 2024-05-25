package com.cleancoders.hackacode.paymentmethod.application.usecases.impl;

import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.paymentmethod.application.dto.NewPaymentMethodDTO;
import com.cleancoders.hackacode.paymentmethod.application.port.in.PaymentMethodPersistence;
import com.cleancoders.hackacode.paymentmethod.application.port.out.PaymentMethodPersistencePort;
import com.cleancoders.hackacode.paymentmethod.application.port.out.PaymentMethodSelectorPort;
import com.cleancoders.hackacode.paymentmethod.application.usecases.PaymentMethodUtils;
import com.cleancoders.hackacode.paymentmethod.domain.PaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;

@UseCase
public class PaymentMethodPersistenceImpl implements PaymentMethodPersistence {

    @Autowired
    private PaymentMethodPersistencePort paymentMethodPersistence;
    @Autowired
    private PaymentMethodSelectorPort paymentMethodSelector;
    @Autowired
    private PaymentMethodUtils paymentMethodUtils;

    @Override
    public PaymentMethod newPaymentMethod(NewPaymentMethodDTO paymentMethodDTO) {

        this.paymentMethodUtils.assertDoesNotExistsByName(paymentMethodDTO.getType());

        return this.paymentMethodPersistence.newPaymentMethod(
                PaymentMethod.builder()
                        .type(paymentMethodDTO.getType())
                        .interest(paymentMethodDTO.getInterest())
                        .build()
        );
    }

    @Override
    public PaymentMethod edit(PaymentMethod body) {
        return this.paymentMethodPersistence.edit(body);
    }
}
