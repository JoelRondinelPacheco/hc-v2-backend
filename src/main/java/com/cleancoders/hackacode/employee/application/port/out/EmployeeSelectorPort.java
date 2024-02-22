package com.cleancoders.hackacode.employee.application.port.out;

import com.cleancoders.hackacode.employee.domain.Employee;

import java.util.List;

public interface EmployeeSelectorPort {
    Employee byId(Long id);
    Employee byEmail(String email);

    List<Employee> getAll();
}
