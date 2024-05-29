package com.joelrondinelpacheco.hackacode.security.adapter.out.persistence;

import com.joelrondinelpacheco.hackacode.common.PersistenceAdapter;
import com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.mapper.UserAuthInfoMapper;
import com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.repository.UsersAuthInfoRepository;
import com.joelrondinelpacheco.hackacode.security.application.entity.CustomUserDetails;
import com.joelrondinelpacheco.hackacode.security.application.port.out.UserAuthPort;
import org.springframework.beans.factory.annotation.Autowired;

@PersistenceAdapter
public class UserAuthPersistenceAdapter implements UserAuthPort {

    @Autowired
    private UsersAuthInfoRepository usersAuthInfoRepository;
    @Autowired
    private UserAuthInfoMapper userAuthInfoMapper;

    @Override
    public CustomUserDetails getUserDetails(String email) {
        return this.usersAuthInfoRepository.findByPerson_Email(email).map(userAuthInfoMapper::entityToApplication).orElseThrow();
    }
}
