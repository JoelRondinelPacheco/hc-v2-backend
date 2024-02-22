package com.cleancoders.hackacode.employee.adapter.out.persistence;

import com.cleancoders.hackacode.common.PersistenceAdapter;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.employee.application.port.out.EmployeeSelectorPort;
import com.cleancoders.hackacode.employee.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

@PersistenceAdapter
public class EmployeeSelectorAdapter implements EmployeeSelectorPort {

    @Autowired
    private EmployeeMySQLRepository employeeMySQLRepository;
    @Autowired
    @Qualifier("employeeMapper")
    private Mapper<Employee, EmployeeEntity> mapper;

    @Override
    public Employee byId(Long id) {
        return null;
    }

    @Override
    public Employee byEmail(String email) {
        return null;
    }

    @Override
    public List<Employee> getAll() {
        return this.employeeMySQLRepository.findAll().stream().map(this.mapper::entityToDomain).toList();
    }
}
