package com.cleancoders.hackacode.security.application.utilities;

import com.cleancoders.hackacode.security.domain.Role;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

public interface AuthUtils {
    List<SimpleGrantedAuthority> getAuthorities(Role role);
}
