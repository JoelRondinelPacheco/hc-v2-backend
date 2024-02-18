package com.cleancoders.hackacode.service.application.dto;

import java.math.BigDecimal;
import java.util.List;

public class NewServiceDTO {
    private String name;
    private String description;
    private BigDecimal price;
    private List<String> categoriesName;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public List<String> getCategoriesName() {
        return categoriesName;
    }
}
