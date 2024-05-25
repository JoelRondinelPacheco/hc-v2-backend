package com.cleancoders.hackacode.security.application.usecases;

import com.cleancoders.hackacode.security.application.dto.user.UserDetailsDTO;
import com.cleancoders.hackacode.security.domain.Role;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface CustomUsersDetailsUseCase {
    UserDetailsDTO getUserDetails(String email);

    List<SimpleGrantedAuthority> getAuthorities(Role role);
}
