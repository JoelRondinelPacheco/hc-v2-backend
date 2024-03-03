package com.cleancoders.hackacode.sale.domain;

import com.cleancoders.hackacode.service.domain.Service;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class Sale {

    private final BigDecimal discount = new BigDecimal("0.9");

    private Long id;
    private Date date;
    private BigDecimal price;
    private SaleType type;

    public void setPrice(List<Service> services) {
        BigDecimal sum = BigDecimal.ZERO;

        for (Service service : services) {
            sum = sum.add(service.getPrice());
        }
        this.price = this.applyDiscount(sum);
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    private BigDecimal applyDiscount(BigDecimal price) {
        return price.multiply(this.discount);
    }
}
