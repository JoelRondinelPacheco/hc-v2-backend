package com.cleancoders.hackacode.security.application.port.out;

import com.cleancoders.hackacode.security.application.dto.user.UserDetailsDTO;

public interface UserAuthPort {
    UserDetailsDTO getUserDetails(String email);
}
