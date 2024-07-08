package com.joelrondinelpacheco.hackacode.employee.application.usecases.impl;

import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.employee.application.dto.NewEmployeeDTO;
import com.joelrondinelpacheco.hackacode.security.application.usecases.JwtTokenService;
import com.joelrondinelpacheco.hackacode.security.application.utilities.AuthUtils;
import com.joelrondinelpacheco.hackacode.employee.application.port.in.EmployeePersistence;
import com.joelrondinelpacheco.hackacode.employee.application.port.out.EmployeePersistencePort;
import com.joelrondinelpacheco.hackacode.employee.application.usecases.EmployeeUtils;
import com.joelrondinelpacheco.hackacode.employee.domain.Employee;
import com.joelrondinelpacheco.hackacode.users.application.dto.UserStarterDTO;

import java.math.BigDecimal;

@UseCase
public class EmployeePersistenceImpl implements EmployeePersistence {

    private final EmployeePersistencePort employeePersistencePort;
    private final EmployeeUtils employeeUtils;
    private final JwtTokenService jwtTokenService;
    private final AuthUtils authUtils;

    public EmployeePersistenceImpl(EmployeePersistencePort employeePersistencePort, EmployeeUtils employeeUtils, JwtTokenService jwtTokenService, AuthUtils authUtils) {
        this.employeePersistencePort = employeePersistencePort;
        this.employeeUtils = employeeUtils;
        this.jwtTokenService = jwtTokenService;
        this.authUtils = authUtils;
    }

    @Override
    public Employee createEmployee(NewEmployeeDTO dto) {
        return null;
    }

    @Override
    public Employee saveEmployee(UserStarterDTO employee, BigDecimal salary) {
        return this.employeePersistencePort.saveEmployeeFromAdmin(employee, salary);
    }
}
