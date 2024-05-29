package com.joelrondinelpacheco.hackacode.security.application.dto.role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class RoleDTO {
    private String name;
    private List<Long> grantedPermissionsIds;
}
