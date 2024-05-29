package com.joelrondinelpacheco.hackacode.paymentmethod.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodMySQLRepository extends JpaRepository<PaymentMethodEntity, Long> {
    boolean existsByType(String name);
}
