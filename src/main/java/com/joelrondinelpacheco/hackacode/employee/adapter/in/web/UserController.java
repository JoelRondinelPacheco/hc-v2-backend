package com.joelrondinelpacheco.hackacode.employee.adapter.in.web;

import com.joelrondinelpacheco.hackacode.employee.application.dto.NewEmployeeDTO;
import com.joelrondinelpacheco.hackacode.employee.application.port.in.EmployeePersistence;
import com.joelrondinelpacheco.hackacode.employee.application.port.in.EmployeeSelector;
import com.joelrondinelpacheco.hackacode.employee.domain.Employee;
import com.joelrondinelpacheco.hackacode.users.application.port.in.RegisterUserUseCase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class UserController {


    private final EmployeePersistence employeePersistence;
    private final EmployeeSelector employeeSelector;
    private final RegisterUserUseCase registerUserUseCase;

    public UserController(EmployeePersistence employeePersistence, EmployeeSelector employeeSelector, RegisterUserUseCase registerUserUseCase) {
        this.employeePersistence = employeePersistence;
        this.employeeSelector = employeeSelector;
        this.registerUserUseCase = registerUserUseCase;
    }

    @PostMapping
    public ResponseEntity<?> newEmployee(@RequestBody NewEmployeeDTO employeeDTO) {
        System.out.println(employeeDTO);
        return ResponseEntity.ok(this.registerUserUseCase.registerEmployee(employeeDTO));

    }

    @GetMapping
    public ResponseEntity<Page<Employee>> getAll(Pageable pageable) {
        return ResponseEntity.ok(this.employeeSelector.getPage(pageable));
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getById(@PathVariable Long employeeId) {
        return ResponseEntity.ok(this.employeeSelector.byId(employeeId));
    }
}
