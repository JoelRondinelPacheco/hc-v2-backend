package com.cleancoders.hackacode.employee.application.port.in;

import com.cleancoders.hackacode.employee.domain.Employee;

public interface EmployeeSelector {
    Employee byId(Long id);
    Employee byEmail(String email);
}
