package com.cleancoders.hackacode.service.adapter.out.persistence.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

@Entity(name = "category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "service_id")
    private ServiceEntity service;
}
