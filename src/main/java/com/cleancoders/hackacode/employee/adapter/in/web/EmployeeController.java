package com.cleancoders.hackacode.employee.adapter.in.web;

import com.cleancoders.hackacode.employee.application.dto.NewEmployeeDTO;
import com.cleancoders.hackacode.employee.application.port.in.EmployeePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeePersistence employeePersistence;

    @PostMapping
    public ResponseEntity<?> newEmployee(NewEmployeeDTO employeeDTO) {
        this.employeePersistence.newEmployee(employeeDTO);
        return null;
    }
}
