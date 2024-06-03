package com.joelrondinelpacheco.hackacode.employee.adapter.in.web;

import com.joelrondinelpacheco.hackacode.employee.application.dto.NewEmployeeDTO;
import com.joelrondinelpacheco.hackacode.employee.application.port.in.EmployeePersistence;
import com.joelrondinelpacheco.hackacode.employee.application.port.in.EmployeeSelector;
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
    private EmployeePersistence employeePersistence;
    @Autowired
    private EmployeeSelector employeeSelector;

    @PostMapping
    public ResponseEntity<?> newEmployee(@RequestBody NewEmployeeDTO employeeDTO) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException {
        //return ResponseEntity.ok(this.employeePersistence.createEmployee(employeeDTO));
        //TODO IMPLEMENT
        return null;
    }

    @GetMapping
    public ResponseEntity<Page<?>> getAll(Pageable pageable) {
        return ResponseEntity.ok(this.employeeSelector.getPage(pageable));
    }
}
