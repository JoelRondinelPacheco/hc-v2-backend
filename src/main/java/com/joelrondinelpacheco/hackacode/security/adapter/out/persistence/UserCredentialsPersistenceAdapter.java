package com.joelrondinelpacheco.hackacode.security.adapter.out.persistence;

import com.joelrondinelpacheco.hackacode.common.PersistenceAdapter;
import com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.entity.UserCredentialsEntity;
import com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.mapper.UserCredentialsMapper;
import com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.repository.UserCredentialsRepository;
import com.joelrondinelpacheco.hackacode.security.application.entity.CustomUserDetails;
import com.joelrondinelpacheco.hackacode.security.application.port.out.UserCredentialsPersistencePort;
import com.joelrondinelpacheco.hackacode.security.application.port.out.UserCredentialsSelectorPort;
import com.joelrondinelpacheco.hackacode.security.domain.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@PersistenceAdapter
public class UserCredentialsPersistenceAdapter implements UserCredentialsPersistencePort, UserCredentialsSelectorPort {
    private final UserCredentialsMapper mapper;
    private final UserCredentialsRepository userCredentialsRepository;

    @Autowired
    public UserCredentialsPersistenceAdapter(UserCredentialsMapper mapper, UserCredentialsRepository userCredentialsRepository) {
        this.mapper = mapper;
        this.userCredentialsRepository = userCredentialsRepository;
    }


    @Override
    public UserCredentials save(UserCredentials userCredentials) {
        UserCredentialsEntity u = this.mapper.domainToEntity(userCredentials);
        u = this.userCredentialsRepository.save(u);
        return this.mapper.entityToDomain(u);
    }

    @Override
    public Optional<CustomUserDetails> getUserDetails(String email) {
        return this.userCredentialsRepository.findByPersonEntity_Email(email).map(this.mapper::entityToCustomUserDetails);
    }

    @Override
    public UserCredentials findByUsername(String username) {
        return this.userCredentialsRepository.findByPersonEntity_Email(username).map(this.mapper::entityToDomain).orElseThrow();
    }
}
