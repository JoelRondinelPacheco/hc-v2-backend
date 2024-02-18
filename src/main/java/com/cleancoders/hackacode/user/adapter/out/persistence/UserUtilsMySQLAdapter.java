package com.cleancoders.hackacode.user.adapter.out.persistence;

import com.cleancoders.hackacode.common.PersistenceAdapter;
import com.cleancoders.hackacode.user.application.port.out.UserUtilsPort;
import org.springframework.beans.factory.annotation.Autowired;

@PersistenceAdapter
public class UserUtilsMySQLAdapter implements UserUtilsPort {

    @Autowired
    private UserMySQLRepository userRepository;

    @Override
    public boolean existsByEmail(String email) {
        return this.userRepository.existsByEmail(email);
    }
}
