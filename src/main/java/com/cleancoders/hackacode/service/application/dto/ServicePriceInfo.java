package com.cleancoders.hackacode.service.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class ServicePriceInfo {
    private Long id;
    private BigDecimal price;
}
