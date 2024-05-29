package com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.mapper;

import com.joelrondinelpacheco.hackacode.common.PersistenceMapper;
import com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.dto.UserAuthInfo;
import com.joelrondinelpacheco.hackacode.security.application.entity.CustomUserDetails;
import com.joelrondinelpacheco.hackacode.security.application.utilities.AuthUtils;
import com.joelrondinelpacheco.hackacode.security.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

@PersistenceMapper
public class UserAuthInfoMapper {

    @Autowired
    private PermissionsRoleMapper roleMapper;
    @Autowired
    private AuthUtils authUtils;

    public CustomUserDetails entityToApplication(UserAuthInfo userAuthInfo) {
        Role role = roleMapper.entityToDomainRole(userAuthInfo.getRole());
        List<SimpleGrantedAuthority> authorities = this.authUtils.getAuthorities(role);

        return CustomUserDetails.builder()
                .email(userAuthInfo.getEmail())
                .password(userAuthInfo.getPassword())
                .authorities(authorities)
                .role(role)
                .build();
    }

}
