package com.cleancoders.hackacode.service.domain;

import com.cleancoders.hackacode.saleitem.domain.SaleItem;
import com.cleancoders.hackacode.service.application.port.in.ServicePersistence;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Service implements SaleItem {
    private Long id;
    private String code;
    private String name;
    private String description;
    private Date createdAt;
    private Date updatedAt;
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


    public Service(ServiceBuilder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.price = builder.price;
    }

    public static class ServiceBuilder {
        private String name;
        private String description;
        private BigDecimal price;

        public ServiceBuilder() {
        }

        public ServiceBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ServiceBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ServiceBuilder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Service build() { return new Service(this);}
    }
}
