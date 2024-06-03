package com.joelrondinelpacheco.hackacode.employee.adapter.out.persistence;

import com.joelrondinelpacheco.hackacode.common.PersistenceAdapter;
import com.joelrondinelpacheco.hackacode.employee.application.port.out.EmployeeUtilsPort;
import org.springframework.beans.factory.annotation.Autowired;

@PersistenceAdapter
public class EmployeeUtilsPersistenceAdapter implements EmployeeUtilsPort {

    @Autowired
    private EmployeeMySQLRepository employeeMySQLRepository;
    @Override
    public boolean existsByEmployeeId(Long id) {
        return this.employeeMySQLRepository.existsByPerson_Id(id);
    }

    @Override
    public boolean existsByEmployeeEmail(String email) {
        return this.employeeMySQLRepository.existsByPerson_Email(email);
    }

    @Override
    public boolean existsById(Long id) {
        return this.employeeMySQLRepository.existsById(id);
    }
}
