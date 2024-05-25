package com.cleancoders.hackacode.security.application.port.out;

import com.cleancoders.hackacode.security.application.entity.CustomUserDetails;

public interface UserAuthPort {
    CustomUserDetails getUserDetails(String email);
}
