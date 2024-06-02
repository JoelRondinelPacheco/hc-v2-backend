package com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.mapper;

import com.joelrondinelpacheco.hackacode.common.PersistenceMapper;
import com.joelrondinelpacheco.hackacode.common.adapter.Mapper;
import com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.entity.UserCredentialsEntity;
import com.joelrondinelpacheco.hackacode.security.domain.UserCredentials;
import org.springframework.beans.factory.annotation.Qualifier;


@PersistenceMapper
@Qualifier("userCredentialsMapper")
public class UserCredentialsMapper implements Mapper<UserCredentials, UserCredentialsEntity> {
    @Override
    public UserCredentials entityToDomain(UserCredentialsEntity userCredentialsEntity) {
        return null;
    }

    @Override
    public UserCredentialsEntity domainToEntity(UserCredentials userCredentials) {
        return null;
    }
}
