package com.cleancoders.hackacode.security.application.usecases;

import com.cleancoders.hackacode.security.application.entity.CustomUserDetails;
import com.cleancoders.hackacode.security.domain.Role;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface CustomUsersDetailsService extends UserDetailsService {
    CustomUserDetails getUserDetails(String email);
}
