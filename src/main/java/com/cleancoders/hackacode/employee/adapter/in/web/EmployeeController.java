package com.cleancoders.hackacode.employee.adapter.in.web;

import com.cleancoders.hackacode.employee.application.dto.NewEmployeeDTO;
import com.cleancoders.hackacode.employee.application.port.in.EmployeePersistence;
import com.cleancoders.hackacode.employee.application.port.in.EmployeeSelector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeePersistence employeePersistence;
    @Autowired
    private EmployeeSelector employeeSelector;

    @PostMapping
    public ResponseEntity<?> newEmployee(NewEmployeeDTO employeeDTO) {
        return ResponseEntity.ok(this.employeePersistence.newEmployee(employeeDTO));
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.employeeSelector.getAll());
    }
}
