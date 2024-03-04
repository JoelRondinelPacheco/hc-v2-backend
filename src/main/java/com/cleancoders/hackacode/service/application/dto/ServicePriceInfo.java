package com.cleancoders.hackacode.service.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
/*
@NoArgsConstructor
@Data
@SuperBuilder*/
public interface ServicePriceInfo {
    Long getId();
    BigDecimal getPrice();
   /* private Long id;
    private BigDecimal price;

    public ServicePriceInfo(Long id, BigDecimal price) {
        this.id = id;
        this.price = price;
    }*/
}
