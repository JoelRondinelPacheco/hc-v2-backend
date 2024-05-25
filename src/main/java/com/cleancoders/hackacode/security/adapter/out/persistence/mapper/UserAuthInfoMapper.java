package com.cleancoders.hackacode.security.adapter.out.persistence.mapper;

import com.cleancoders.hackacode.common.PersistenceMapper;
import com.cleancoders.hackacode.security.adapter.out.persistence.dto.UserAuthInfo;
import com.cleancoders.hackacode.security.application.entity.CustomUserDetails;
import com.cleancoders.hackacode.security.application.utilities.AuthUtils;
import com.cleancoders.hackacode.security.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

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
                .build();
    }

    public List<SimpleGrantedAuthority> getAuthorities(Role role) {
        List<SimpleGrantedAuthority> authorities = role.getPermissions().stream()
                .map(each -> each.getOperation().getName())
                .map(each -> new SimpleGrantedAuthority(each))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));

        return authorities;
    }
}
