package com.cleancoders.hackacode.service.domain;

import com.cleancoders.hackacode.saleitem.domain.SaleItem;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Service implements SaleItem {
    private Long id;
    private String code;
    private String name;
    private String description;
    private Date date;
    private BigDecimal price;
    private List<Category> categories;

    @Override
    public BigDecimal getPrice() {
        return this.price;
    }

    @Override
    public int getItemsSize() {
        return 1;
    }
}
