package com.cleancoders.hackacode.employee.application.usecases.impl;

import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.employee.application.dto.NewEmployeeDTO;
import com.cleancoders.hackacode.employee.application.port.in.EmployeePersistence;
import com.cleancoders.hackacode.employee.application.port.out.EmployeePersistencePort;
import com.cleancoders.hackacode.employee.application.usecases.EmployeeUtils;
import com.cleancoders.hackacode.employee.domain.Employee;
import com.cleancoders.hackacode.user.application.port.in.UserPersistence;
import com.cleancoders.hackacode.user.application.port.in.UserUtils;
import com.cleancoders.hackacode.user.application.usecases.UserBuilder;
import com.cleancoders.hackacode.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

@UseCase
public class EmployeePersistenceImpl implements EmployeePersistence {

    @Autowired
    private EmployeePersistencePort employeePersistencePort;
    @Autowired
    private UserPersistence userRepository;

    @Autowired
    private UserUtils userUtils;
    @Autowired
    private EmployeeUtils employeeUtils;
    @Autowired
    private UserBuilder userBuilder;

    @Override
    public Employee newEmployee(NewEmployeeDTO employeeDTO) {
        //CHECKEA QUE EL USUARIO EXISTA USUARIO NO EXISTE
        this.userUtils.assertDoesNotExistsByEmail(employeeDTO.getEmail());
        //NO EXISTE EMPLEADO RELACIONADO A ESE USUARIO
        this.employeeUtils.assertDoesNotExistsByUserEmail(employeeDTO.getEmail());

        //TODO IMPL
        User user = this.userRepository.save(this.userBuilder.userFromDTO(employeeDTO));

        Employee employee = new Employee();
        employee.setSalary(employee.getSalary());
        employee.setUserId(user.getId());

        return this.employeePersistencePort.save(employee);
    }
}
