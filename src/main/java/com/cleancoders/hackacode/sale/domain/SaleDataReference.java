package com.cleancoders.hackacode.sale.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class SaleDataReference extends Sale {
    private Long paymentMethod;
    private Long client;
    private Long employee;
    private List<SaleItemReference> saleItemReferences;

    private SaleDataReference(List<SaleItemReference> saleItemReferences) {
        this.saleItemReferences = saleItemReferences;
        super.setPrice(saleItemReferences);
        super.setSaleType(saleItemReferences);
    }

    public static SaleDataReference withSaleItemReferences(List<SaleItemReference> saleItemReferences) {
        return new SaleDataReference(saleItemReferences);
    }

}
