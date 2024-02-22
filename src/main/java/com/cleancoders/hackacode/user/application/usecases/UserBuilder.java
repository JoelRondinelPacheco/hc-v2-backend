package com.cleancoders.hackacode.user.application.usecases;

import com.cleancoders.hackacode.user.application.dto.NewUserDTO;
import com.cleancoders.hackacode.user.domain.User;

public interface UserBuilder {
    User userFromDTO(NewUserDTO userDTO);
}
