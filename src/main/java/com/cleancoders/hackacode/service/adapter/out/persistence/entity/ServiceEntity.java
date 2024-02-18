package com.cleancoders.hackacode.service.adapter.out.persistence.entity;

import com.cleancoders.hackacode.sale.adapter.out.persistence.SaleEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity(name = "service")
public class ServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    private String description;

    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;

    private BigDecimal price;

    @OneToMany(mappedBy = "service", fetch = FetchType.EAGER)
    private List<CategoryEntity> categories;

    @ManyToMany(mappedBy = "services", fetch = FetchType.LAZY)
    private List<SaleEntity> sales;

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

    public BigDecimal getPrice() {
        return price;
    }

    public List<CategoryEntity> getCategories() {
        return categories;
    }

    public List<SaleEntity> getSales() {
        return sales;
    }
}
