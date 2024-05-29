package com.joelrondinelpacheco.hackacode.security.application.port.out;

import com.joelrondinelpacheco.hackacode.security.application.entity.CustomUserDetails;

public interface UserAuthPort {
    CustomUserDetails getUserDetails(String email);
}
