package com.joelrondinelpacheco.hackacode.security.adapter.out.persistence;

import com.joelrondinelpacheco.hackacode.common.PersistenceAdapter;
import com.joelrondinelpacheco.hackacode.common.adapter.Mapper;
import com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.entity.UserCredentialsEntity;
import com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.repository.UserCredentialsRepository;
import com.joelrondinelpacheco.hackacode.security.application.port.out.UserCredentialsPersistencePort;
import com.joelrondinelpacheco.hackacode.security.domain.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@PersistenceAdapter
public class UserCredentialsPersistenceAdapter implements UserCredentialsPersistencePort {
    @Qualifier("userCredentialsMapper")
    private final Mapper<UserCredentials, UserCredentialsEntity> mapper;
    private final UserCredentialsRepository userCredentialsRepository;

    @Autowired
    public UserCredentialsPersistenceAdapter(Mapper<UserCredentials, UserCredentialsEntity> mapper, UserCredentialsRepository userCredentialsRepository) {
        this.mapper = mapper;
        this.userCredentialsRepository = userCredentialsRepository;
    }


    @Override
    public UserCredentials save(UserCredentials userCredentials) {
        UserCredentialsEntity u = this.mapper.domainToEntity(userCredentials);
        u = this.userCredentialsRepository.save(u);
        return this.mapper.entityToDomain(u);
    }
}
