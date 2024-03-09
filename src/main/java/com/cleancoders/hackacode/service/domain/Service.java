package com.cleancoders.hackacode.service.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@NoArgsConstructor
@Data
@SuperBuilder
public class Service {
    private Long id;
    private BigDecimal price;

    public Service(Long id, BigDecimal price) {
        this.id = id;
        this.price = price;
    }
}
