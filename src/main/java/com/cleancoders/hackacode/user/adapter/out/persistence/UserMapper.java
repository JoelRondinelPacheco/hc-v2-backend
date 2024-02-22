package com.cleancoders.hackacode.user.adapter.out.persistence;

import com.cleancoders.hackacode.common.PersistenceMapper;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.user.domain.User;
import com.cleancoders.hackacode.person.adapter.out.persistence.PersonEntity;
import com.cleancoders.hackacode.person.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@PersistenceMapper
@Qualifier("userMapper")
public class UserMapper implements Mapper<User, UserEntity> {

    @Autowired
    @Qualifier("personMapper")
    private Mapper<Person, PersonEntity> personMapper;

    @Override
    public User entityToDomain(UserEntity userEntity) {
        Person person = this.personMapper.entityToDomain(userEntity.getPerson());
        person.setId(userEntity.getPerson().getId());

        User user = new User();
        user.setPerson(person);
        user.setSalary(userEntity.getSalary());
        user.setId(userEntity.getId());
        return user;
    }

    @Override
    public UserEntity domainToEntity(User employee) {
        PersonEntity user = this.personMapper.domainToEntity(employee.getPerson());
        user.setId(employee.getPerson().getId());
        return UserEntity.builder()
                .salary(employee.getSalary())
                .person(user)
                .build();
    }
}
