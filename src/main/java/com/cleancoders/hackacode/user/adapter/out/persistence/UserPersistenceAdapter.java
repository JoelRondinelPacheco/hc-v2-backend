package com.cleancoders.hackacode.user.adapter.out.persistence;

import com.cleancoders.hackacode.common.PersistenceAdapter;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.user.adapter.out.persistence.mapper.UserMapper;
import com.cleancoders.hackacode.user.application.dto.UserInfoDTO;
import com.cleancoders.hackacode.user.application.port.out.UserPersistencePort;
import com.cleancoders.hackacode.user.domain.User;
import com.cleancoders.hackacode.person.adapter.out.persistence.PersonMySQLRepository;
import com.cleancoders.hackacode.user.domain.UserBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

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
