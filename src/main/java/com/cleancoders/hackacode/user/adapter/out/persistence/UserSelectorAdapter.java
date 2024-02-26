package com.cleancoders.hackacode.user.adapter.out.persistence;

import com.cleancoders.hackacode.common.PersistenceAdapter;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.user.adapter.out.persistence.mapper.UserMapper;
import com.cleancoders.hackacode.user.application.port.out.UserSelectorPort;
import com.cleancoders.hackacode.user.domain.User;
import com.cleancoders.hackacode.user.domain.UserBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

@PersistenceAdapter
public class UserSelectorAdapter implements UserSelectorPort {

    @Autowired
    private UserMySQLRepository userMySQLRepository;
    @Autowired
    private UserMapper mapper;

    @Override
    public User byId(Long id) {
        return null;
    }

    @Override
    public User byEmail(String email) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return this.userMySQLRepository.findAll().stream().map(this.mapper::entityToDomain).toList();
    }
}
