package com.cleancoders.hackacode.paymentmethod.application.port.out;

public interface PaymentMethodUtilsPort {

    boolean existsById(Long id);
    boolean existsByName(String name);
}
