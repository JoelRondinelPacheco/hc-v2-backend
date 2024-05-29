package com.joelrondinelpacheco.hackacode.user.adapter.out.persistence;

import com.joelrondinelpacheco.hackacode.common.PersistenceAdapter;
import com.joelrondinelpacheco.hackacode.user.adapter.out.persistence.mapper.UserMapper;
import com.joelrondinelpacheco.hackacode.user.application.port.out.UserPersistencePort;
import com.joelrondinelpacheco.hackacode.user.domain.User;
import com.joelrondinelpacheco.hackacode.person.adapter.out.persistence.PersonMySQLRepository;
import com.joelrondinelpacheco.hackacode.user.domain.UserBase;
import org.springframework.beans.factory.annotation.Autowired;

@PersistenceAdapter
public class UserPersistenceAdapter implements UserPersistencePort {

    @Autowired
    private PersonMySQLRepository personMySQLRepository;

    @Autowired
    private UserMySQLRepository userMySQLRepository;
    @Autowired
    private UserMapper mapper;


    @Override
    public UserBase registerUser(User user) {

        UserEntity userEntity = this.mapper.domainToEntity(user);
        userEntity.setPassword(user.getPassword());

        UserEntity userSaved = this.userMySQLRepository.save(userEntity);

        return this.mapper.entityToDomain(userSaved);
    }
}
