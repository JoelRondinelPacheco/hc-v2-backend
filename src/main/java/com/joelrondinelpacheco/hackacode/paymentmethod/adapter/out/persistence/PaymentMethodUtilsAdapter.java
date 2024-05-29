package com.joelrondinelpacheco.hackacode.paymentmethod.adapter.out.persistence;

import com.joelrondinelpacheco.hackacode.common.PersistenceAdapter;
import com.joelrondinelpacheco.hackacode.paymentmethod.application.port.out.PaymentMethodUtilsPort;
import org.springframework.beans.factory.annotation.Autowired;

@PersistenceAdapter
public class PaymentMethodUtilsAdapter implements PaymentMethodUtilsPort {
    @Autowired
    private PaymentMethodMySQLRepository paymentMethodMySQLRepository;

    @Override
    public boolean existsById(Long id) {
        return this.paymentMethodMySQLRepository.existsById(id);
    }

    @Override
    public boolean existsByName(String name) {
        return this.paymentMethodMySQLRepository.existsByType(name);
    }
}
