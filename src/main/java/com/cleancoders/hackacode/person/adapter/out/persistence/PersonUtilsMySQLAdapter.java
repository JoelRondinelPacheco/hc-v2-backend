package com.cleancoders.hackacode.person.adapter.out.persistence;

import com.cleancoders.hackacode.common.PersistenceAdapter;
import com.cleancoders.hackacode.person.application.port.out.PersonUtilsPort;
import org.springframework.beans.factory.annotation.Autowired;

@PersistenceAdapter
public class PersonUtilsMySQLAdapter implements PersonUtilsPort {

    @Autowired
    private PersonMySQLRepository userRepository;

    @Override
    public boolean existsByEmail(String email) {
        return this.userRepository.existsByEmail(email);
    }

    @Override
    public boolean existsById(Long id) {
        return this.userRepository.existsById(id);
    }

}
