package com.joelrondinelpacheco.hackacode.user.adapter.out.persistence;

import com.joelrondinelpacheco.hackacode.common.PersistenceAdapter;
import com.joelrondinelpacheco.hackacode.user.adapter.out.persistence.mapper.UserMapper;
import com.joelrondinelpacheco.hackacode.user.application.port.out.UserSelectorPort;
import com.joelrondinelpacheco.hackacode.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
    public Page<User> getPage(Pageable pageable) {
        return this.userMySQLRepository.findAll(pageable).map(this.mapper::entityToDomain);
    }

    public UserEntity entityById(Long id) {
        return this.userMySQLRepository.findById(id).orElseThrow();
    }
}
