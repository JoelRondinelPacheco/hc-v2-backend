package com.cleancoders.hackacode.security.domain;

import java.util.List;

public class Role {
    private Long id;
    private String name;
    private List<GrantedPermission> permissions;
}
