package com.joelrondinelpacheco.hackacode.sale.domain;

import com.joelrondinelpacheco.hackacode.paymentmethod.domain.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;


@AllArgsConstructor
@Data
@SuperBuilder
public class Sale {
    private PaymentMethod paymentMethod;

    private Long id;
    private BigDecimal total;
    private SaleType type;
    private BigDecimal interest;
    private BigDecimal discount;



    public Sale() {
        this.discount = new BigDecimal("0.10");
    }
    public void setTotal(List<SaleItemReference> items) {
        BigDecimal total = BigDecimal.ZERO;

        for (SaleItemReference saleItemReference : items) {
            BigDecimal priceItem = saleItemReference.getService().getPrice().multiply(saleItemReference.getQuantity());
            total = total.add(priceItem).setScale(2, RoundingMode.HALF_DOWN);
        }

        total = this.applyDiscount(total, items.size());
        this.total = this.applyInterest(total);
        System.out.println("total itneres");
        System.out.println(this.total);
    }

    private BigDecimal applyDiscount(BigDecimal total, int itemsSize) {

        if (itemsSize == 1) {
            this.setDiscount(new BigDecimal("0.00"));
        }
        return total.multiply(
                new BigDecimal("1.0000").subtract(this.getDiscount()).setScale(4, RoundingMode.HALF_DOWN)
        ).setScale(2, RoundingMode.HALF_DOWN);
    }

    private BigDecimal applyInterest(BigDecimal total) {
        return total.multiply(
                new BigDecimal("1.0000").add(this.getPaymentMethod().getInterest()).setScale(4, RoundingMode.HALF_DOWN)
        ).setScale(2, RoundingMode.HALF_DOWN);
    }

    public void setSaleType(List<SaleItemReference> saleItemReferences) {
        if (saleItemReferences.size() > 1) {
            setType(SaleType.PACKAGE);
        } else {
            setType(SaleType.SINGLE_SALE);
        }
    }


}
