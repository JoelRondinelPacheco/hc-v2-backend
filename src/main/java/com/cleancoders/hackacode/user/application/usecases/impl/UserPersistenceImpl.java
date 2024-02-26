package com.cleancoders.hackacode.user.application.usecases.impl;

import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.user.application.dto.NewEmployeeDTO;
import com.cleancoders.hackacode.user.application.port.in.UserPersistence;
import com.cleancoders.hackacode.user.application.port.out.UserPersistencePort;
import com.cleancoders.hackacode.user.application.usecases.EmployeeUtils;
import com.cleancoders.hackacode.user.domain.User;
import com.cleancoders.hackacode.person.application.port.in.PersonPersistence;
import com.cleancoders.hackacode.person.application.port.in.PersonUtils;
import com.cleancoders.hackacode.person.application.usecases.PersonBuilder;
import com.cleancoders.hackacode.person.domain.Person;
import com.cleancoders.hackacode.user.domain.UserBase;
import org.springframework.beans.factory.annotation.Autowired;

@UseCase
public class UserPersistenceImpl implements UserPersistence {

    @Autowired
    private UserPersistencePort userPersistencePort;
    @Autowired
    private PersonPersistence userRepository;

    @Autowired
    private PersonUtils personUtils;
    @Autowired
    private EmployeeUtils employeeUtils;
    @Autowired
    private PersonBuilder personBuilder;

    @Override
    public UserBase newEmployee(NewEmployeeDTO employeeDTO) {
        //CHECKEA QUE EL USUARIO EXISTA USUARIO NO EXISTE
        this.personUtils.assertDoesNotExistsByEmail(employeeDTO.getEmail());
        //NO EXISTE EMPLEADO RELACIONADO A ESE USUARIO
        this.employeeUtils.assertDoesNotExistsByUserEmail(employeeDTO.getEmail());

        Person person = this.userRepository.save(this.personBuilder.userFromDTO(employeeDTO));

        String password = this.employeeUtils.createRandomPassword();

        User user = new User();
        user.setSalary(user.getSalary());
        user.setPerson(person);
        user.setPassword(password);

        return this.userPersistencePort.registerUser(user);
    }
}
