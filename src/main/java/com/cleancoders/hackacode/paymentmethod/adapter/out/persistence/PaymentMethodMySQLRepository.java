package com.cleancoders.hackacode.paymentmethod.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodMySQLRepository extends JpaRepository<PaymentMethodEntity, Long> {
}
