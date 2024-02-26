package com.cleancoders.hackacode.user.adapter.in.web;

import com.cleancoders.hackacode.user.application.dto.NewEmployeeDTO;
import com.cleancoders.hackacode.user.application.port.in.UserPersistence;
import com.cleancoders.hackacode.user.application.port.in.UserSelector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class UserController {

    @Autowired
    private UserPersistence userPersistence;
    @Autowired
    private UserSelector userSelector;

    @PostMapping
    public ResponseEntity<?> newEmployee(@RequestBody NewEmployeeDTO employeeDTO) {
        return ResponseEntity.ok(this.userPersistence.newEmployee(employeeDTO));
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.userSelector.getAll());
    }
}
