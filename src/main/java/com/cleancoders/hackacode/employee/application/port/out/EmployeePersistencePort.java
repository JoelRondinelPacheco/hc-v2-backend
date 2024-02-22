package com.cleancoders.hackacode.employee.application.port.out;

import com.cleancoders.hackacode.employee.domain.Employee;

public interface EmployeePersistencePort {

    Employee save(Employee employee);
}
