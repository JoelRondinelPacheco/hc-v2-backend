package com.cleancoders.hackacode.security.adapter.in.web;

import com.cleancoders.hackacode.security.application.dto.grantedpermission.GrantedPermissionDTO;
import com.cleancoders.hackacode.security.application.dto.module.ModuleDTO;
import com.cleancoders.hackacode.security.application.dto.operation.OperationDTO;
import com.cleancoders.hackacode.security.application.dto.role.RoleDTO;
import com.cleancoders.hackacode.security.application.port.in.SecurityConfigPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class RoleController {

    @Autowired
    private SecurityConfigPersistence securityConfigPersistence;

    @PostMapping("/module")
    public ResponseEntity<?> createModule(@RequestBody ModuleDTO module) {
        return ResponseEntity.ok(this.securityConfigPersistence.createModule(module));
    }

    @PostMapping("/operation")
    public ResponseEntity<?> createOperation(OperationDTO operation) {
        return ResponseEntity.ok(this.securityConfigPersistence.createOperation(operation));
    }

    @PostMapping("/role")
    public ResponseEntity<?> createRole(RoleDTO role) {
        return ResponseEntity.ok(this.securityConfigPersistence.createRole(role));
    }

    @PostMapping("/granted-permission")
    public ResponseEntity<?> createGrantedPermission(GrantedPermissionDTO grantedPermission) {
        return ResponseEntity.ok(this.securityConfigPersistence.createGrantedPermission(grantedPermission));
    }
}
