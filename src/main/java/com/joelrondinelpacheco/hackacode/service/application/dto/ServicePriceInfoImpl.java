package com.joelrondinelpacheco.hackacode.service.application.dto;

import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@Setter
public class ServicePriceInfoImpl implements ServicePriceInfo {

    private Long id;
    private BigDecimal price;

    public ServicePriceInfoImpl(Long id, BigDecimal price) {
        this.id = id;
        this.price = price;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public BigDecimal getPrice() {
        return this.price;
    }
}
