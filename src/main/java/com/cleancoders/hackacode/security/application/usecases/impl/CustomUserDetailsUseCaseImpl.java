package com.cleancoders.hackacode.security.application.usecases.impl;

import com.cleancoders.hackacode.security.application.dto.user.UserDetailsDTO;
import com.cleancoders.hackacode.security.application.port.out.UserAuthPort;
import com.cleancoders.hackacode.security.application.usecases.CustomUsersDetailsUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class CustomUserDetailsUseCaseImpl implements CustomUsersDetailsUseCase {

    @Autowired
    private UserAuthPort userAuthPort;
    @Override
    public UserDetailsDTO getUserDetails(String email) {
        UserDetailsDTO userDetails = this.userAuthPort.getUserDetails(email);

        return null;

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
