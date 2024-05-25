package com.cleancoders.hackacode.security.application.dto.grantedpermission;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class GrantedPermissionDTO {
    private Long roleId;
    private Long operationId;
}
