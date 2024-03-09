package com.cleancoders.hackacode.service.adapter.out.persistence.entity;

import com.cleancoders.hackacode.sale.adapter.out.persistence.SaleEntity;
import com.cleancoders.hackacode.sale.adapter.out.persistence.SaleItemEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity(name = "service")
@NoArgsConstructor
@AllArgsConstructor
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

    @OneToMany(mappedBy = "service", fetch = FetchType.LAZY)
    private List<SaleItemEntity> saleItem;
}
