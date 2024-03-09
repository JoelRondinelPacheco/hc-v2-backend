package com.cleancoders.hackacode.sale.domain;

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
public class Sale {

    private final BigDecimal discount = new BigDecimal("0.9");

    private Long id;
    private BigDecimal price;
    private SaleType type;

    public void setPrice(List<SaleItemReference> items) {
        BigDecimal sum = BigDecimal.ZERO;

        for (SaleItemReference saleItemReference : items) {
            BigDecimal priceItem = saleItemReference.getService().getPrice().multiply(saleItemReference.getQuantity());
            sum = sum.add(priceItem);
        }

        if (items.size() > 1) {
            this.price = this.applyDiscount(sum);
        } else {
            this.price = sum;
        }
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    private BigDecimal applyDiscount(BigDecimal price) {
        return price.multiply(this.discount);
    }

    public void setSaleType(List<SaleItemReference> saleItemReferences) {
        if (saleItemReferences.size() > 1) {
            setType(SaleType.PACKAGE);
        } else {
            setType(SaleType.SINGLE_SALE);
        }
    }
}
