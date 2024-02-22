package com.cleancoders.hackacode.service.adapter.out.persistence.entity;

import com.cleancoders.hackacode.sale.adapter.out.persistence.SaleEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity(name = "service")
@Data
@Builder
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

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @ManyToMany(mappedBy = "services", fetch = FetchType.LAZY)
    private List<SaleEntity> sales;
}
