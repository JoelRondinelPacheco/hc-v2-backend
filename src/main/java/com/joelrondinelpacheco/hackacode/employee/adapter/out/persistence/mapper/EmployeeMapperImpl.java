package com.joelrondinelpacheco.hackacode.employee.adapter.out.persistence.mapper;

import com.joelrondinelpacheco.hackacode.common.PersistenceMapper;
import com.joelrondinelpacheco.hackacode.common.adapter.Mapper;
import com.joelrondinelpacheco.hackacode.employee.adapter.out.persistence.EmployeeEntity;
import com.joelrondinelpacheco.hackacode.employee.domain.Employee;
import com.joelrondinelpacheco.hackacode.person.adapter.out.persistence.PersonEntity;
import com.joelrondinelpacheco.hackacode.person.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@PersistenceMapper
public class EmployeeMapperImpl implements EmployeeMapper {

    @Autowired
    @Qualifier("personMapper")
    private Mapper<Person, PersonEntity> personMapper;

    @Override
    public Employee entityToDomain(EmployeeEntity entity) {
        Person person = this.personMapper.entityToDomain(entity.getPerson());
        person.setId(entity.getPerson().getId());

        Employee employee = new Employee();
        employee.setPerson(person);
        employee.setSalary(entity.getSalary());
        employee.setId(entity.getId());
        return employee;
    }

    @Override
    public EmployeeEntity domainToEntity(Employee domain) {
        PersonEntity user = this.personMapper.domainToEntity(domain.getPerson());
        user.setId(domain.getPerson().getId());
        return EmployeeEntity.builder()
                .salary(domain.getSalary())
                .person(user)
                .build();
    }

}
