package com.cleancoders.hackacode.sale.domain;

import com.cleancoders.hackacode.service.domain.ServiceData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class SaleItemBase {
    private Long id;
    private BigDecimal quantity;
    private LocalDate from;
    private LocalDate to;
}
