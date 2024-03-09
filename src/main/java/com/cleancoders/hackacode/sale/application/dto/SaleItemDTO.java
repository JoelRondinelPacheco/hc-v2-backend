package com.cleancoders.hackacode.sale.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SaleItemDTO {
    private Long serviceId;
    private BigDecimal quantity;
    private LocalDate from;
    private LocalDate to;
}
