package com.cleancoders.hackacode.user.adapter.out.persistence;

import com.cleancoders.hackacode.common.PersistenceAdapter;
import com.cleancoders.hackacode.user.application.port.out.UserUtilsPort;
import org.springframework.beans.factory.annotation.Autowired;

@PersistenceAdapter
public class UserUtilsPersistenceAdapter implements UserUtilsPort {

    @Autowired
    private UserMySQLRepository userMySQLRepository;
    @Override
    public boolean existsByUserId(Long id) {
        return this.userMySQLRepository.existsByUser_Id(id);
    }

    @Override
    public boolean existsByUserEmail(String email) {
        return this.userMySQLRepository.existsByUser_Email(email);
    }
}
