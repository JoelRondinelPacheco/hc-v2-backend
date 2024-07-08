package com.joelrondinelpacheco.hackacode.employee.application.usecases.impl;

import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.employee.application.dto.NewEmployeeDTO;
import com.joelrondinelpacheco.hackacode.employee.application.dto.UpdateEmployeeDTO;
import com.joelrondinelpacheco.hackacode.employee.application.port.out.EmployeeSelectorPort;
import com.joelrondinelpacheco.hackacode.person.application.port.out.PersonPersistencePort;
import com.joelrondinelpacheco.hackacode.person.domain.Person;
import com.joelrondinelpacheco.hackacode.security.application.usecases.JwtTokenService;
import com.joelrondinelpacheco.hackacode.security.application.utilities.AuthUtils;
import com.joelrondinelpacheco.hackacode.employee.application.port.in.EmployeePersistence;
import com.joelrondinelpacheco.hackacode.employee.application.port.out.EmployeePersistencePort;
import com.joelrondinelpacheco.hackacode.employee.application.usecases.EmployeeUtils;
import com.joelrondinelpacheco.hackacode.employee.domain.Employee;
import com.joelrondinelpacheco.hackacode.users.application.dto.UserStarterDTO;

import java.math.BigDecimal;
import java.util.Objects;

@UseCase
public class EmployeePersistenceImpl implements EmployeePersistence {

    private final EmployeePersistencePort employeePersistencePort;
    private final EmployeeSelectorPort employeeSelectorPort;
    private final PersonPersistencePort personRepository;
    private final EmployeeUtils employeeUtils;
    private final JwtTokenService jwtTokenService;
    private final AuthUtils authUtils;

    public EmployeePersistenceImpl(EmployeePersistencePort employeePersistencePort, EmployeeSelectorPort employeeSelectorPort, PersonPersistencePort personRepository, EmployeeUtils employeeUtils, JwtTokenService jwtTokenService, AuthUtils authUtils) {
        this.employeePersistencePort = employeePersistencePort;
        this.employeeSelectorPort = employeeSelectorPort;
        this.personRepository = personRepository;
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

    @Override
    public Employee update(UpdateEmployeeDTO body) {
        Employee employee = this.employeeSelectorPort.byId(body.getId());

        if (!Objects.equals(employee.getPerson().getId(), body.getPersonId())) {
            throw new RuntimeException("TODO EX");
        }

        Person person = employee.getPerson();
        person.setName(body.getName());
        person.setLastname(body.getLastname());
        person.setDni(body.getDni());
        person.setBirthday(body.getBirthday());

        person = this.personRepository.save(person);

        employee.setPerson(person);
        employee.setSalary(body.getSalary());

        return this.employeePersistencePort.saveEmployee(employee);
    }
}
