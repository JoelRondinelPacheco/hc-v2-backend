package com.joelrondinelpacheco.hackacode.employee.adapter.out.persistence;

import com.joelrondinelpacheco.hackacode.common.PersistenceAdapter;
import com.joelrondinelpacheco.hackacode.common.domain.EntityNotFoundException;
import com.joelrondinelpacheco.hackacode.employee.adapter.out.persistence.mapper.EmployeeMapper;
import com.joelrondinelpacheco.hackacode.employee.application.port.out.EmployeeSelectorPort;
import com.joelrondinelpacheco.hackacode.employee.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@PersistenceAdapter
public class EmployeeSelectorAdapter implements EmployeeSelectorPort {

    @Autowired
    private EmployeeMySQLRepository employeeMySQLRepository;
    @Autowired
    private EmployeeMapper mapper;

    @Override
    public Employee byId(Long id) {
        return this.employeeMySQLRepository.findById(id).map(this.mapper::entityToDomain).orElseThrow(
                () -> new EntityNotFoundException("Employee with ID: " + id + ", not found.")
        );
    }

    @Override
    public Employee byEmail(String email) {
        return null;
    }

    @Override
    public Page<Employee> getPage(Pageable pageable) {
        return this.employeeMySQLRepository.findAll(pageable).map(this.mapper::entityToDomain);
    }

    public EmployeeEntity entityById(Long id) {
        return this.employeeMySQLRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Employee with ID: " + id + ", not found.")
        );
    }
    public EmployeeEntity entityByEmail(String email) { return this.employeeMySQLRepository.findByPerson_Email(email).orElseThrow(
            () -> new EntityNotFoundException("Employee with email: " + email + ", not found.")
    ); }
}
