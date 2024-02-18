package com.cleancoders.hackacode.service.adapter.out.persistence.entity;

import com.cleancoders.hackacode.sale.adapter.out.persistence.SaleEntity;
import jakarta.persistence.*;

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
    private Date date;
    private BigDecimal price;

    @OneToMany(mappedBy = "service")
    private List<CategoryEntity> categories;

    @ManyToMany(mappedBy = "services")
    private List<SaleEntity> sales;

}
