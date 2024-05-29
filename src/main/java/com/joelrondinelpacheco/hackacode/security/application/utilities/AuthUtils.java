package com.joelrondinelpacheco.hackacode.security.application.utilities;

import com.joelrondinelpacheco.hackacode.security.domain.Role;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

public interface AuthUtils {
    List<SimpleGrantedAuthority> getAuthorities(Role role);
}
