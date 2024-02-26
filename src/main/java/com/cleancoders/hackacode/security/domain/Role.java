package com.cleancoders.hackacode.security.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Role {
    private Long id;
    private String name;
    private List<GrantedPermission> permissions;
}
