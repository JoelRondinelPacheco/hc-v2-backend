package com.joelrondinelpacheco.hackacode.paymentmethod.application.usecases;

public interface PaymentMethodUtils {
    void assertExistsById(Long id);
    void assertDoesNotExistsById(Long id);
    void assertExistsByName(String name);
    void assertDoesNotExistsByName(String name);
}
