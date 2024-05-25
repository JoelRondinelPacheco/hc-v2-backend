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

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@CrossOrigin
@RestController
@RequestMapping("/employee")
public class UserController {

    @Autowired
    private UserPersistence userPersistence;
    @Autowired
    private UserSelector userSelector;

    @PostMapping
    public ResponseEntity<?> newEmployee(@RequestBody NewEmployeeDTO employeeDTO) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException {
        return ResponseEntity.ok(this.userPersistence.newEmployee(employeeDTO));
    }

    @GetMapping
    public ResponseEntity<Page<User>> getAll(Pageable pageable) {
        return ResponseEntity.ok(this.userSelector.getPage(pageable));
    }
}
