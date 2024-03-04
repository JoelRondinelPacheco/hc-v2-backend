package com.cleancoders.hackacode.security.adapter.in.web;

import com.cleancoders.hackacode.security.application.dto.grantedpermission.GrantedPermissionDTO;
import com.cleancoders.hackacode.security.application.dto.module.ModuleDTO;
import com.cleancoders.hackacode.security.application.dto.operation.OperationDTO;
import com.cleancoders.hackacode.security.application.dto.role.RoleDTO;
import com.cleancoders.hackacode.security.application.port.in.*;
import com.cleancoders.hackacode.security.domain.GrantedPermission;
import com.cleancoders.hackacode.security.domain.Module;
import com.cleancoders.hackacode.security.domain.Operation;
import com.cleancoders.hackacode.security.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/security")
public class SecurityController {

    @Autowired
    private ModulePersistence modulePersistence;
    @Autowired
    private ModuleSelector moduleSelector;

    @Autowired
    private OperationPersistence operationPersistence;
    @Autowired
    private OperationSelector operationSelector;

    @Autowired
    private GrantedPermissionPersistence grantedPermissionPersistence;
    @Autowired
    private GrantedPermissionSelector grantedPermissionSelector;

    @Autowired
    private RolePersistence rolePersistence;
    @Autowired
    private RoleSelector roleSelector;

    @PostMapping("/module")
    public ResponseEntity<Module> addModule(@RequestBody ModuleDTO body) {
        return ResponseEntity.ok(this.modulePersistence.addModule(body));
    }

    @GetMapping("/module")
    public ResponseEntity<Page<Module>> getModulePage(Pageable pageable) {
        return ResponseEntity.ok(this.moduleSelector.getPage(pageable));
    }

    @PostMapping("/operation")
    public ResponseEntity<?> createOperation(OperationDTO operation) {
        return ResponseEntity.ok(this.operationPersistence.createOperation(operation));
    }

    @GetMapping("/operation")
    public ResponseEntity<Page<Operation>> getOperationPage(Pageable pageable) {
        return ResponseEntity.ok(this.operationSelector.getPage(pageable));
    }

    @PostMapping("/granted-permission")
    public ResponseEntity<GrantedPermission> createGrantedPermission(GrantedPermissionDTO grantedPermission) {
        return ResponseEntity.ok(this.grantedPermissionPersistence.addGrantedPermission(grantedPermission));
    }

    @GetMapping("/granted-permission")
    public ResponseEntity<Page<GrantedPermission>> getGrantedPermissionPage(Pageable pageable) {
        return ResponseEntity.ok(this.grantedPermissionSelector.getPage(pageable));
    }

    @PostMapping("/role")
    public ResponseEntity<Role> createRole(@RequestBody RoleDTO body) {
        return ResponseEntity.ok(this.rolePersistence.addRole(body));
    }

    @GetMapping("/role")
    public ResponseEntity<Page<Role>> getRolePage(Pageable pageable) {
        return ResponseEntity.ok(this.roleSelector.getPage(pageable));
    }
}
