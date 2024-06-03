package com.joelrondinelpacheco.hackacode.employee.application.port.in;

import com.joelrondinelpacheco.hackacode.employee.application.dto.NewEmployeeDTO;
import com.joelrondinelpacheco.hackacode.employee.domain.Employee;
import com.joelrondinelpacheco.hackacode.person.domain.Person;

import java.io.IOException;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface EmployeePersistence {
    Employee createEmployee(Person person, BigDecimal salary);
    Employee save(Employee employee);
}
