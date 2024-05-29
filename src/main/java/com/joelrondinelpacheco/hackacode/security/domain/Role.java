package com.joelrondinelpacheco.hackacode.security.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class  Role {
    private Long id;
    private String name;
    private List<GrantedPermission> permissions;
}
