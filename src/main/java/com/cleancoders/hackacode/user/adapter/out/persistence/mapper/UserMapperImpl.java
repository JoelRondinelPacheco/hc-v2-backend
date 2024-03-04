package com.cleancoders.hackacode.user.adapter.out.persistence.mapper;

import com.cleancoders.hackacode.common.PersistenceMapper;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.person.adapter.out.persistence.PersonEntity;
import com.cleancoders.hackacode.person.domain.Person;
import com.cleancoders.hackacode.user.adapter.out.persistence.UserEntity;
import com.cleancoders.hackacode.user.domain.User;
import com.cleancoders.hackacode.user.domain.UserBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@PersistenceMapper
public class UserMapperImpl implements UserMapper {

    @Autowired
    @Qualifier("personMapper")
    private Mapper<Person, PersonEntity> personMapper;

    @Override
    public User entityToDomain(UserEntity entity) {
        Person person = this.personMapper.entityToDomain(entity.getPerson());
        person.setId(entity.getPerson().getId());

        User user = new User();
        user.setPerson(person);
        user.setSalary(entity.getSalary());
        user.setId(entity.getId());
        return user;
    }

    @Override
    public UserEntity domainToEntity(User domain) {
        PersonEntity user = this.personMapper.domainToEntity(domain.getPerson());
        user.setId(domain.getPerson().getId());
        return UserEntity.builder()
                .salary(domain.getSalary())
                .person(user)
                .build();
    }

}
