package com.cleancoders.hackacode.security.application.usecases.impl;

import com.cleancoders.hackacode.security.application.usecases.CustomUsersDetails;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class CustomUserDetailsImpl implements CustomUsersDetails {
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
