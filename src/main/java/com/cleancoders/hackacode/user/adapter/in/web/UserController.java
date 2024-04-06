package com.cleancoders.hackacode.user.adapter.in.web;

import com.cleancoders.hackacode.user.application.dto.NewEmployeeDTO;
import com.cleancoders.hackacode.user.application.port.in.UserPersistence;
import com.cleancoders.hackacode.user.application.port.in.UserSelector;
import com.cleancoders.hackacode.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
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
    public ResponseEntity<Page<User>> getAll(Pageable pageable) {
        return ResponseEntity.ok(this.userSelector.getPage(pageable));
    }
}
