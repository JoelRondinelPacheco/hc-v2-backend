package com.cleancoders.hackacode.user.application.port.in;

import com.cleancoders.hackacode.client.application.dto.NewUserDTO;
import com.cleancoders.hackacode.user.domain.User;

public interface UserUtils {
    void existsByEmail(String email);

}
