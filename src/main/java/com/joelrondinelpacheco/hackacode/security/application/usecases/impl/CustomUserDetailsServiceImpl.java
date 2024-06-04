package com.joelrondinelpacheco.hackacode.security.application.usecases.impl;

import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.security.application.entity.CustomUserDetails;
import com.joelrondinelpacheco.hackacode.security.application.port.out.UserCredentialsPersistencePort;
import com.joelrondinelpacheco.hackacode.security.application.usecases.CustomUsersDetailsService;
import com.joelrondinelpacheco.hackacode.security.application.utilities.AuthUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

@UseCase
public class CustomUserDetailsServiceImpl implements CustomUsersDetailsService {

    @Autowired
    private UserCredentialsPersistencePort userCredentialsPort;
    @Autowired
    private AuthUtils authUtils;
    @Override
    public CustomUserDetails getUserDetails(String email) {
        return this.userCredentialsPort.getUserDetails(email).orElseThrow();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userCredentialsPort.getUserDetails(username).orElseThrow(
                () -> new UsernameNotFoundException("Invalid credentials")
        );
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
