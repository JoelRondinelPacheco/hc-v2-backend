package com.joelrondinelpacheco.hackacode.employee.application.port.out;

import com.joelrondinelpacheco.hackacode.employee.domain.Employee;
import com.joelrondinelpacheco.hackacode.users.application.dto.UserStarterDTO;

import java.math.BigDecimal;

public interface EmployeePersistencePort {

    Employee registerUser(Employee employee);

    Employee saveEmployeeFromAdmin(UserStarterDTO employee, BigDecimal salary);
}
