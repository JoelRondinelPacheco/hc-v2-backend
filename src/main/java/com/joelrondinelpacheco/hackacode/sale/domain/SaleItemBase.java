package com.joelrondinelpacheco.hackacode.sale.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class SaleItemBase {
    private Long id;
    private Integer quantity;
    private Date from;
    private Date to;
}
