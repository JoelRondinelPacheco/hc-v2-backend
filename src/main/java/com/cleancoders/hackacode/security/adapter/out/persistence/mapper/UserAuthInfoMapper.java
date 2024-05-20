package com.cleancoders.hackacode.security.adapter.out.persistence.mapper;

import com.cleancoders.hackacode.common.PersistenceMapper;
import com.cleancoders.hackacode.security.adapter.out.persistence.dto.UserAuthInfo;
import com.cleancoders.hackacode.security.application.dto.user.UserDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;

@PersistenceMapper
public class UserAuthInfoMapper {

    @Autowired
    private PermissionsRoleMapper roleMapper;

    public UserDetailsDTO entityToApplication(UserAuthInfo userAuthInfo) {

        return UserDetailsDTO.builder()
                .email(userAuthInfo.getEmail())
                .password(userAuthInfo.getEmail())
                .role(roleMapper.entityToDomainRole(userAuthInfo.getRole()))
                .build();
    }
}
