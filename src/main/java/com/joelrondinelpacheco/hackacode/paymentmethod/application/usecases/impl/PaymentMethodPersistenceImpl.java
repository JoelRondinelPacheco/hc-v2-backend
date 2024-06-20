package com.joelrondinelpacheco.hackacode.paymentmethod.application.usecases.impl;

import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.common.application.validators.ObjectsValidator;
import com.joelrondinelpacheco.hackacode.paymentmethod.application.dto.NewPaymentMethodDTO;
import com.joelrondinelpacheco.hackacode.paymentmethod.application.port.in.PaymentMethodPersistence;
import com.joelrondinelpacheco.hackacode.paymentmethod.application.port.out.PaymentMethodPersistencePort;
import com.joelrondinelpacheco.hackacode.paymentmethod.application.port.out.PaymentMethodSelectorPort;
import com.joelrondinelpacheco.hackacode.paymentmethod.application.usecases.PaymentMethodUtils;
import com.joelrondinelpacheco.hackacode.paymentmethod.domain.PaymentMethod;

@UseCase
public class PaymentMethodPersistenceImpl implements PaymentMethodPersistence {


    private final PaymentMethodPersistencePort paymentMethodPersistence;
    private final PaymentMethodSelectorPort paymentMethodSelector;
    private final PaymentMethodUtils paymentMethodUtils;
    private final ObjectsValidator<NewPaymentMethodDTO> validator;

    public PaymentMethodPersistenceImpl(PaymentMethodPersistencePort paymentMethodPersistence, PaymentMethodSelectorPort paymentMethodSelector, PaymentMethodUtils paymentMethodUtils, ObjectsValidator<NewPaymentMethodDTO> validator) {
        this.paymentMethodPersistence = paymentMethodPersistence;
        this.paymentMethodSelector = paymentMethodSelector;
        this.paymentMethodUtils = paymentMethodUtils;
        this.validator = validator;
    }

    @Override
    public PaymentMethod newPaymentMethod(NewPaymentMethodDTO paymentMethodDTO) {
        validator.validate(paymentMethodDTO);
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
