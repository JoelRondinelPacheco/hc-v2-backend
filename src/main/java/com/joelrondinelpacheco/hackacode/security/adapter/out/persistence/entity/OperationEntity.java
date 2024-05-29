package com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "operation")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OperationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String path;
    private String httpMethod;
    private boolean permitAll;

    @ManyToOne
    @JoinColumn(name = "module_id")
    private ModuleEntity module;
}
