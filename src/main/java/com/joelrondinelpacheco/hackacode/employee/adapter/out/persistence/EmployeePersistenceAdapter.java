package com.joelrondinelpacheco.hackacode.employee.adapter.out.persistence;

import com.joelrondinelpacheco.hackacode.common.PersistenceAdapter;
import com.joelrondinelpacheco.hackacode.common.adapter.Mapper;
import com.joelrondinelpacheco.hackacode.employee.adapter.out.persistence.mapper.EmployeeMapper;
import com.joelrondinelpacheco.hackacode.employee.application.port.out.EmployeePersistencePort;
import com.joelrondinelpacheco.hackacode.employee.domain.Employee;
import com.joelrondinelpacheco.hackacode.person.adapter.out.persistence.PersonEntity;
import com.joelrondinelpacheco.hackacode.person.adapter.out.persistence.PersonMySQLRepository;
import com.joelrondinelpacheco.hackacode.person.domain.Person;
import com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.entity.RoleEntity;
import com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.entity.UserCredentialsEntity;
import com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.mapper.UserCredentialsMapper;
import com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.repository.RoleMySQLRepository;
import com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.repository.UserCredentialsRepository;
import com.joelrondinelpacheco.hackacode.users.application.dto.UserStarterDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@PersistenceAdapter
public class EmployeePersistenceAdapter implements EmployeePersistencePort {

    private final PersonMySQLRepository personMySQLRepository;
    private final EmployeeMySQLRepository employeeMySQLRepository;
    private final EmployeeMapper mapper;
    private final RoleMySQLRepository roleRepository;
    private final Mapper<Person, PersonEntity> personMapper;
    private final UserCredentialsMapper userCredentialsMapper;
    private final UserCredentialsRepository userCredentialsRepository;


    public EmployeePersistenceAdapter(
            PersonMySQLRepository personMySQLRepository,
            EmployeeMySQLRepository employeeMySQLRepository,
            EmployeeMapper mapper,
            RoleMySQLRepository roleRepository,
            @Qualifier("personMapper") Mapper<Person, PersonEntity> personMapper, UserCredentialsMapper userCredentialsMapper, UserCredentialsRepository userCredentialsRepository) {
        this.personMySQLRepository = personMySQLRepository;
        this.employeeMySQLRepository = employeeMySQLRepository;
        this.mapper = mapper;
        this.roleRepository = roleRepository;
        this.personMapper = personMapper;
        this.userCredentialsMapper = userCredentialsMapper;
        this.userCredentialsRepository = userCredentialsRepository;
    }


    @Override
    public Employee registerUser(Employee employee) {

        EmployeeEntity employeeEntity = this.mapper.domainToEntity(employee);

        EmployeeEntity userSaved = this.employeeMySQLRepository.save(employeeEntity);

        return this.mapper.entityToDomain(userSaved);
    }

    @Override
    @Transactional
    public Employee saveEmployeeFromAdmin(UserStarterDTO employee, BigDecimal salary) {
        RoleEntity role = this.roleRepository.findById(employee.getUserCredentials().getRole()).orElseThrow();
        PersonEntity personEntity = this.personMapper.domainToEntity(employee.getPerson());
        PersonEntity personSaved = this.personMySQLRepository.save(personEntity);
        UserCredentialsEntity userCredentialsEntity = this.userCredentialsMapper.domainReferenceToEntity(employee.getUserCredentials());

        userCredentialsEntity.setPersonEntity(personSaved);
        userCredentialsEntity.setRole(role);

        this.userCredentialsRepository.save(userCredentialsEntity);
        EmployeeEntity newEmployee = EmployeeEntity.builder()
                .salary(salary)
                .person(personSaved)
                .build();
        return this.mapper.entityToDomain(
                this.employeeMySQLRepository.save(newEmployee)
        );
    }
}
