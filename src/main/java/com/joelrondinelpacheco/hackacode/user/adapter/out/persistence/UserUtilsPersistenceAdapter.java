package com.joelrondinelpacheco.hackacode.user.adapter.out.persistence;

import com.joelrondinelpacheco.hackacode.common.PersistenceAdapter;
import com.joelrondinelpacheco.hackacode.user.application.port.out.UserUtilsPort;
import org.springframework.beans.factory.annotation.Autowired;

@PersistenceAdapter
public class UserUtilsPersistenceAdapter implements UserUtilsPort {

    @Autowired
    private UserMySQLRepository userMySQLRepository;
    @Override
    public boolean existsByUserId(Long id) {
        return this.userMySQLRepository.existsByPerson_Id(id);
    }

    @Override
    public boolean existsByUserEmail(String email) {
        return this.userMySQLRepository.existsByPerson_Email(email);
    }

    @Override
    public boolean existsById(Long id) {
        return this.userMySQLRepository.existsById(id);
    }
}
