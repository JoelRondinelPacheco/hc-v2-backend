package com.cleancoders.hackacode.service.domain;

import com.cleancoders.hackacode.saleitem.domain.SaleItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Service implements SaleItem {
    private Long id;
    private String code;
    private String name;
    private String description;
    private Date createdAt;
    private Date updatedAt;
    private BigDecimal price;
    private Category category;
    private Long categoryId;


    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public int getItemsSize() {
        return 0;
    }
}
