package com.cleancoders.hackacode.service.application.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class NewServiceDTO {
    private String code;
    private String name;
    private String description;
    private BigDecimal price;
    private String categoryId;
}
