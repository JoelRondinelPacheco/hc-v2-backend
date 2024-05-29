package com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "granted_permission")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class GrantedPermissionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;

    @ManyToOne
    @JoinColumn(name = "operation_id")
    private OperationEntity operation;
}
