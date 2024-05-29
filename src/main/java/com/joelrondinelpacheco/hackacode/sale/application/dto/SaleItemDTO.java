package com.joelrondinelpacheco.hackacode.sale.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SaleItemDTO {
    private Long serviceId;
    private Integer quantity;
    private Date from;
    private Date to;
}
