package com.cleancoders.hackacode.sale.domain;

public interface SaleI<CLIENT, EMPLOYEE, PAYMENT_METHOD> {
    CLIENT getClientI();
    EMPLOYEE employeeI();
    PAYMENT_METHOD getPaymentMethodI();
}
