package com.cleancoders.hackacode.sale.domain;

import com.cleancoders.hackacode.saleitem.domain.SaleItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class Sale {
    private Long id;
    private Date date;
    private BigDecimal price;
    private SaleItem saleItem;
    private SaleType type;
}
