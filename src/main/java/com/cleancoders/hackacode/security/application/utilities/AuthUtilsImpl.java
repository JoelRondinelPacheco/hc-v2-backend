package com.cleancoders.hackacode.security.application.utilities;

import com.cleancoders.hackacode.security.domain.Role;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuthUtilsImpl implements AuthUtils{
    @Override
    public List<SimpleGrantedAuthority> getAuthorities(Role role) {
        List<SimpleGrantedAuthority> authorities = role.getPermissions().stream()
                .map(each -> each.getOperation().getName())
                .map(each -> new SimpleGrantedAuthority(each))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));

        return authorities;
    }
}
