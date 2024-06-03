package com.joelrondinelpacheco.hackacode.employee.adapter.out.persistence;

import com.joelrondinelpacheco.hackacode.common.PersistenceAdapter;
import com.joelrondinelpacheco.hackacode.employee.adapter.out.persistence.mapper.EmployeeMapper;
import com.joelrondinelpacheco.hackacode.employee.application.port.out.EmployeePersistencePort;
import com.joelrondinelpacheco.hackacode.employee.domain.Employee;
import com.joelrondinelpacheco.hackacode.person.adapter.out.persistence.PersonMySQLRepository;
import org.springframework.beans.factory.annotation.Autowired;

@PersistenceAdapter
public class EmployeePersistenceAdapter implements EmployeePersistencePort {

    @Autowired
    private PersonMySQLRepository personMySQLRepository;

    @Autowired
    private EmployeeMySQLRepository employeeMySQLRepository;
    @Autowired
    private EmployeeMapper mapper;


    @Override
    public Employee registerUser(Employee employee) {

        EmployeeEntity employeeEntity = this.mapper.domainToEntity(employee);

        EmployeeEntity userSaved = this.employeeMySQLRepository.save(employeeEntity);

        return this.mapper.entityToDomain(userSaved);
    }
}
