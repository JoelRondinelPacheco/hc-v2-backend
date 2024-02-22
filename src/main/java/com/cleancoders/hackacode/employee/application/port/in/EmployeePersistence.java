package com.cleancoders.hackacode.employee.application.port.in;

import com.cleancoders.hackacode.employee.application.dto.NewEmployeeDTO;
import com.cleancoders.hackacode.employee.domain.Employee;

public interface EmployeePersistence {
    Employee newEmployee(NewEmployeeDTO employeeDTO);
}
