package com.cleancoders.hackacode.employee.application.port.in;

import com.cleancoders.hackacode.employee.domain.Employee;

import java.util.List;

public interface EmployeeSelector {
    Employee byId(Long id);
    Employee byEmail(String email);

    List<Employee> getAll();
}
