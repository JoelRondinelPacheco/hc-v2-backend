package com.joelrondinelpacheco.hackacode.employee.application.port.in;

import com.joelrondinelpacheco.hackacode.employee.application.dto.NewEmployeeDTO;
import com.joelrondinelpacheco.hackacode.employee.application.dto.UpdateEmployeeDTO;
import com.joelrondinelpacheco.hackacode.employee.domain.Employee;
import com.joelrondinelpacheco.hackacode.users.application.dto.UserStarterDTO;

import java.math.BigDecimal;

public interface EmployeePersistence {
    Employee createEmployee(NewEmployeeDTO dto);
    Employee saveEmployee(UserStarterDTO employee, BigDecimal salary);

    Employee update(UpdateEmployeeDTO body);
}
