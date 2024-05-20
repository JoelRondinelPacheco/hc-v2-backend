package com.cleancoders.hackacode.security.application.usecases;

import com.cleancoders.hackacode.security.application.dto.user.UserDetailsDTO;
import org.springframework.security.core.userdetails.UserDetails;

public interface CustomUsersDetailsUseCase {
    UserDetailsDTO getUserDetails(String email);
}
