package com.joelrondinelpacheco.hackacode.security.adapter.in.web;

import com.joelrondinelpacheco.hackacode.security.application.dto.grantedpermission.GrantedPermissionDTO;
import com.joelrondinelpacheco.hackacode.security.application.dto.module.ModuleDTO;
import com.joelrondinelpacheco.hackacode.security.application.dto.operation.OperationDTO;
import com.joelrondinelpacheco.hackacode.security.application.dto.role.RoleDTO;
import com.joelrondinelpacheco.hackacode.security.domain.GrantedPermission;
import com.joelrondinelpacheco.hackacode.security.domain.Module;
import com.joelrondinelpacheco.hackacode.security.domain.Operation;
import com.joelrondinelpacheco.hackacode.security.domain.Role;
import com.joelrondinelpacheco.hackacode.security.application.port.in.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/security")
public class SecurityController {


    private final ModulePersistence modulePersistence;
    private final ModuleSelector moduleSelector;


    private final OperationPersistence operationPersistence;
    private final OperationSelector operationSelector;

    private final GrantedPermissionPersistence grantedPermissionPersistence;
    private final GrantedPermissionSelector grantedPermissionSelector;

    private final RolePersistence rolePersistence;
    private final RoleSelector roleSelector;

    public SecurityController(
            ModulePersistence modulePersistence,
            ModuleSelector moduleSelector,
            OperationPersistence operationPersistence,
            OperationSelector operationSelector,
            GrantedPermissionPersistence grantedPermissionPersistence,
            GrantedPermissionSelector grantedPermissionSelector,
            RolePersistence rolePersistence,
            RoleSelector roleSelector) {
        this.modulePersistence = modulePersistence;
        this.moduleSelector = moduleSelector;
        this.operationPersistence = operationPersistence;
        this.operationSelector = operationSelector;
        this.grantedPermissionPersistence = grantedPermissionPersistence;
        this.grantedPermissionSelector = grantedPermissionSelector;
        this.rolePersistence = rolePersistence;
        this.roleSelector = roleSelector;
    }

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
