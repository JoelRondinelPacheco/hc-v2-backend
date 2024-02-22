package com.cleancoders.hackacode.user.adapter.out.persistence;

import com.cleancoders.hackacode.common.PersistenceAdapter;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.user.application.port.out.UserPersistencePort;
import com.cleancoders.hackacode.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@PersistenceAdapter
public class UserPersistenceAdapter implements UserPersistencePort {
    @Autowired
    private UserMySQLRepository userMySQLRepository;
    @Autowired
    @Qualifier("userMapper")
    private Mapper<User, UserEntity> mapper;

    @Override
    public User save(User user) {
        UserEntity userEntity = this.userMySQLRepository.save(this.mapper.domainToEntity(user));
        User userSaved = this.mapper.entityToDomain(userEntity);
        userSaved.setId(userEntity.getId());
        return userSaved;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public String delete(Long userId) {
        return null;
    }
}
