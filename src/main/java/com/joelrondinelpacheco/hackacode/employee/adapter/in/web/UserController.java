package com.joelrondinelpacheco.hackacode.employee.adapter.in.web;

import com.joelrondinelpacheco.hackacode.employee.application.dto.NewEmployeeDTO;
import com.joelrondinelpacheco.hackacode.employee.application.port.in.EmployeePersistence;
import com.joelrondinelpacheco.hackacode.employee.application.port.in.EmployeeSelector;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

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
    public ResponseEntity<?> newEmployee(@RequestBody NewEmployeeDTO employeeDTO) {
        //return ResponseEntity.ok(this.employeePersistence.createEmployee(employeeDTO));
        //TODO IMPLEMENT
        return null;

    }

    @GetMapping
    public ResponseEntity<Page<?>> getAll(Pageable pageable) {
        return ResponseEntity.ok(this.employeeSelector.getPage(pageable));
    }
}
