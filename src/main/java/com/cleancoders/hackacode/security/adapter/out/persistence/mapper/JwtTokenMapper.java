package com.cleancoders.hackacode.security.adapter.out.persistence.mapper;

import com.cleancoders.hackacode.common.PersistenceMapper;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.security.adapter.out.persistence.entity.JwtTokenEntity;
import com.cleancoders.hackacode.security.domain.JwtToken;
import org.springframework.beans.factory.annotation.Qualifier;

@PersistenceMapper
@Qualifier("jwtTokenMapper")
public class JwtTokenMapper implements Mapper<JwtToken, JwtTokenEntity> {
    @Override
    public JwtToken entityToDomain(JwtTokenEntity jwtTokenEntity) {

        return JwtToken.builder()
                .id(jwtTokenEntity.getId())
                .token(jwtTokenEntity.getToken())
                .expiration(jwtTokenEntity.getExpiration())
                .isValid(jwtTokenEntity.isValid())
                .token(jwtTokenEntity.getToken())
                .build();
    }

    @Override
    public JwtTokenEntity domainToEntity(JwtToken jwtToken) {
        return null;
    }
}
