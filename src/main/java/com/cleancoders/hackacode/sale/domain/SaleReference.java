package com.cleancoders.hackacode.sale.domain;

import com.cleancoders.hackacode.paymentmethod.domain.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class SaleReference extends Sale {
    private Long client;
    private Long employee;
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
