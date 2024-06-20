package com.joelrondinelpacheco.hackacode.employee.adapter.in.web;

import com.joelrondinelpacheco.hackacode.common.adapter.validators.ObjectsValidator;
import com.joelrondinelpacheco.hackacode.employee.application.dto.NewEmployeeDTO;
import com.joelrondinelpacheco.hackacode.employee.application.port.in.EmployeePersistence;
import com.joelrondinelpacheco.hackacode.employee.application.port.in.EmployeeSelector;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/employee")
public class UserController {


    private final EmployeePersistence employeePersistence;
    private final EmployeeSelector employeeSelector;
    private final ObjectsValidator<NewEmployeeDTO> validator;

    public UserController(EmployeePersistence employeePersistence, EmployeeSelector employeeSelector, ObjectsValidator<NewEmployeeDTO> validator) {
        this.employeePersistence = employeePersistence;
        this.employeeSelector = employeeSelector;
        this.validator = validator;
    }

    @PostMapping
    public ResponseEntity<?> newEmployee(@RequestBody @Valid NewEmployeeDTO employeeDTO, BindingResult bindingResult) {
        //return ResponseEntity.ok(this.employeePersistence.createEmployee(employeeDTO));
        var violations = validator.validate(employeeDTO);
        if (!violations.isEmpty()) {
            return ResponseEntity.ok(violations.stream().collect(Collectors.joining(" | ")));
        }
        System.out.println(bindingResult);
        //TODO IMPLEMENT
        return ResponseEntity.ok("Todo bien");
    }

    @GetMapping
    public ResponseEntity<Page<?>> getAll(Pageable pageable) {
        return ResponseEntity.ok(this.employeeSelector.getPage(pageable));
    }
}
