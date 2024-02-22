package com.cleancoders.hackacode.employee.adapter.out.persistence;

import com.cleancoders.hackacode.common.PersistenceAdapter;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.employee.application.port.out.EmployeePersistencePort;
import com.cleancoders.hackacode.employee.domain.Employee;
import com.cleancoders.hackacode.user.adapter.out.persistence.UserMySQLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@PersistenceAdapter
@Qualifier("employeeMapper")
public class EmployeePersistenceAdapter implements EmployeePersistencePort {

    @Autowired
    private UserMySQLRepository userMySQLRepository;

    @Autowired
    private EmployeeMySQLRepository employeeMySQLRepository;
    @Autowired
    @Qualifier("employeeMapper")
    private Mapper<Employee, EmployeeEntity> mapper;


    @Override
    public Employee save(Employee employee) {
        EmployeeEntity employeeEntity = this.employeeMySQLRepository.save(this.mapper.domainToEntity(employee));
        return this.mapper.entityToDomain(employeeEntity);
    }
}
