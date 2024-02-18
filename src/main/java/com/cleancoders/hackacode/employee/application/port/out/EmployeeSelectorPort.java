package com.cleancoders.hackacode.employee.application.port.out;

import com.cleancoders.hackacode.employee.domain.Employee;

public interface EmployeeSelectorPort {
    Employee byId(Long id);
    Employee byEmail(String email);
}
