package com.joelrondinelpacheco.hackacode.employee.adapter.in.web;

import com.joelrondinelpacheco.hackacode.employee.application.dto.NewEmployeeDTO;
import com.joelrondinelpacheco.hackacode.employee.application.port.in.EmployeePersistence;
import com.joelrondinelpacheco.hackacode.employee.application.port.in.EmployeeSelector;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@RestController
@RequestMapping("/employee")
public class UserController {


    private final EmployeePersistence employeePersistence;
    private final EmployeeSelector employeeSelector;

    public UserController(EmployeePersistence employeePersistence, EmployeeSelector employeeSelector) {
        this.employeePersistence = employeePersistence;
        this.employeeSelector = employeeSelector;
    }

    @PostMapping
    public ResponseEntity<?> newEmployee(@RequestBody @Valid NewEmployeeDTO employeeDTO, BindingResult bindingResult) {
        //return ResponseEntity.ok(this.employeePersistence.createEmployee(employeeDTO));
        System.out.println(bindingResult);
        //TODO IMPLEMENT
        return null;
    }

    @GetMapping
    public ResponseEntity<Page<?>> getAll(Pageable pageable) {
        return ResponseEntity.ok(this.employeeSelector.getPage(pageable));
    }
}
