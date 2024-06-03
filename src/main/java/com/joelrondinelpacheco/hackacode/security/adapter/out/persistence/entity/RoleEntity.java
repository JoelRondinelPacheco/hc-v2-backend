package com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.entity;

import com.joelrondinelpacheco.hackacode.person.adapter.out.persistence.PersonEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "role")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    private List<GrantedPermissionEntity> permissions;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private List<UserCredentialsEntity> persons;
}
