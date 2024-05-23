package com.cleancoders.hackacode.security.adapter.out.persistence;

import com.cleancoders.hackacode.common.PersistenceAdapter;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.security.adapter.out.persistence.entity.JwtTokenEntity;
import com.cleancoders.hackacode.security.adapter.out.persistence.repository.JwtTokenMySQLRepository;
import com.cleancoders.hackacode.security.application.port.out.JwtTokenOutPort;
import com.cleancoders.hackacode.security.domain.JwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@PersistenceAdapter
public class JwtTokenPersistenceAdapter implements JwtTokenOutPort {

    @Autowired
    private JwtTokenMySQLRepository jwtTokenRepository;
    @Autowired
    @Qualifier("jwtTokenMapper")
    private Mapper<JwtToken, JwtTokenEntity> mapper;

    @Override
    public JwtToken findByToken(String jwt) {
        return this.jwtTokenRepository.findByToken(jwt).map(this.mapper::entityToDomain).orElseThrow();
    }

    @Override
    public int invalidateToken(String jwt) {
        return this.jwtTokenRepository.invalidateToken(jwt, false);
    }
}
