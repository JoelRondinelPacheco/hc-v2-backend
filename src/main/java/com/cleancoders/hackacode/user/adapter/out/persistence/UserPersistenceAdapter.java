package com.cleancoders.hackacode.user.adapter.out.persistence;

import com.cleancoders.hackacode.common.PersistenceAdapter;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.user.application.port.out.UserPersistencePort;
import com.cleancoders.hackacode.user.domain.User;
import com.cleancoders.hackacode.person.adapter.out.persistence.PersonMySQLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@PersistenceAdapter
@Qualifier("employeeMapper")
public class UserPersistenceAdapter implements UserPersistencePort {

    @Autowired
    private PersonMySQLRepository personMySQLRepository;

    @Autowired
    private UserMySQLRepository userMySQLRepository;
    @Autowired
    @Qualifier("userMapper")
    private Mapper<User, UserEntity> mapper;


    @Override
    public User save(User user) {
        UserEntity userEntity = this.userMySQLRepository.save(this.mapper.domainToEntity(user));
        return this.mapper.entityToDomain(userEntity);
    }
}
