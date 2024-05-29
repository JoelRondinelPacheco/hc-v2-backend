package com.joelrondinelpacheco.hackacode.user.adapter.out.persistence.mapper;

import com.joelrondinelpacheco.hackacode.common.PersistenceMapper;
import com.joelrondinelpacheco.hackacode.common.adapter.Mapper;
import com.joelrondinelpacheco.hackacode.person.adapter.out.persistence.PersonEntity;
import com.joelrondinelpacheco.hackacode.person.domain.Person;
import com.joelrondinelpacheco.hackacode.user.adapter.out.persistence.UserEntity;
import com.joelrondinelpacheco.hackacode.user.domain.User;
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
