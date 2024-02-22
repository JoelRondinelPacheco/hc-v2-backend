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
    private Date createdAt;
    private Date updatedAt;
    private BigDecimal price;
    private Category category;
    private Long categoryId;

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", price=" + price +
                ", categories=" + category +
                '}';
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Category getCategory() {
        return category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

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
        this.categoryId = builder.categoryId;
    }

    public static class ServiceBuilder {
        private String name;
        private String description;
        private BigDecimal price;
        private Long categoryId;

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

        public ServiceBuilder categoryId(Long categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public Service build() { return new Service(this);}
    }
}
