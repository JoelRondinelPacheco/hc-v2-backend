package com.joelrondinelpacheco.hackacode.sale.domain;

import com.joelrondinelpacheco.hackacode.paymentmethod.domain.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class SaleReference extends Sale {
    private Long client;
    private String employeeEmail;
    private List<SaleItemReference> saleItemReferences;

    private SaleReference(List<SaleItemReference> saleItemReferences, PaymentMethod paymentMethod) {
        this.saleItemReferences = saleItemReferences;
        super.setPaymentMethod(paymentMethod);
        super.setSaleType(saleItemReferences);
        super.setTotal(saleItemReferences);
    }

    public static SaleReference withSaleItemReferencesAndPaymentMethod(List<SaleItemReference> saleItemReferences, PaymentMethod paymentMethod) {
        return new SaleReference(saleItemReferences, paymentMethod);
    }
}