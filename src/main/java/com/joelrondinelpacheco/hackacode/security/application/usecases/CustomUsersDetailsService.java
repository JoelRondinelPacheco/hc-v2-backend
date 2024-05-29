package com.joelrondinelpacheco.hackacode.security.application.usecases;

import com.joelrondinelpacheco.hackacode.security.application.entity.CustomUserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface CustomUsersDetailsService extends UserDetailsService {
    CustomUserDetails getUserDetails(String email);
}
