package com.cleancoders.hackacode.security.application.usecases.impl;

import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.security.application.entity.CustomUserDetails;
import com.cleancoders.hackacode.security.application.port.out.UserAuthPort;
import com.cleancoders.hackacode.security.application.usecases.CustomUsersDetailsService;
import com.cleancoders.hackacode.security.application.utilities.AuthUtils;
import com.cleancoders.hackacode.security.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@UseCase
public class CustomUserDetailsServiceImpl implements CustomUsersDetailsService {

    @Autowired
    private UserAuthPort userAuthPort;
    @Autowired
    private AuthUtils authUtils;
    @Override
    public CustomUserDetails getUserDetails(String email) {
        return this.userAuthPort.getUserDetails(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.getUserDetails(username);
    }

    /*
    if (super.getRole() == null) return null;
        if (super.getRole().getPermissions() == null) return null;

        List<SimpleGrantedAuthority> authorities = super.getRole().getPermissions().stream()
                .map(each -> each.getOperation().getName())
                .map(each -> new SimpleGrantedAuthority(each))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + super.getRole().getName()));

        return authorities;
     */
}
