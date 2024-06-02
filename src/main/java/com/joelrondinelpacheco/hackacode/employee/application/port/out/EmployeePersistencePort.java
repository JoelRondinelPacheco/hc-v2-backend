package com.joelrondinelpacheco.hackacode.employee.application.port.out;

import com.joelrondinelpacheco.hackacode.employee.domain.Employee;

public interface EmployeePersistencePort {

    Employee registerUser(Employee employee);
}
