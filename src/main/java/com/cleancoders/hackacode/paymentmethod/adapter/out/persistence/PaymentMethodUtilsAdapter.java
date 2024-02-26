package com.cleancoders.hackacode.paymentmethod.adapter.out.persistence;

import com.cleancoders.hackacode.common.PersistenceAdapter;
import com.cleancoders.hackacode.paymentmethod.application.port.out.PaymentMethodUtilsPort;
import org.springframework.beans.factory.annotation.Autowired;

@PersistenceAdapter
public class PaymentMethodUtilsAdapter implements PaymentMethodUtilsPort {
    @Autowired
    private PaymentMethodMySQLRepository paymentMethodMySQLRepository;

    @Override
    public boolean existsById(Long id) {
        return this.paymentMethodMySQLRepository.existsById(id);
    }
}
