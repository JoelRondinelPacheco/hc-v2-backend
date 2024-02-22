package com.cleancoders.hackacode.employee.adapter.out.persistence;

import com.cleancoders.hackacode.common.PersistenceMapper;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.employee.domain.Employee;
import com.cleancoders.hackacode.user.adapter.out.persistence.UserEntity;
import com.cleancoders.hackacode.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@PersistenceMapper
@Qualifier("employeeMapper")
public class EmployeeMapper implements Mapper<Employee, EmployeeEntity> {

    @Autowired
    @Qualifier("userMapper")
    private Mapper<User, UserEntity> userMapper;

    @Override
    public Employee entityToDomain(EmployeeEntity employeeEntity) {
        User user = this.userMapper.entityToDomain(employeeEntity.getUser());
        user.setId(employeeEntity.getUser().getId());

        Employee employee = new Employee();
        employee.setUser(user);
        employee.setSalary(employeeEntity.getSalary());
        employee.setId(employeeEntity.getId());
        return employee;
    }

    @Override
    public EmployeeEntity domainToEntity(Employee employee) {
        UserEntity user = this.userMapper.domainToEntity(employee.getUser());
        user.setId(employee.getUser().getId());
        return EmployeeEntity.builder()
                .salary(employee.getSalary())
                .user(user)
                .build();
    }
}
