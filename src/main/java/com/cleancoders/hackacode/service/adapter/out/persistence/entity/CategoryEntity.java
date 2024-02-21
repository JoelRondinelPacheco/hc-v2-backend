package com.cleancoders.hackacode.service.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Entity(name = "category")
@Data
@Builder
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
    private List<ServiceEntity> services;

}
