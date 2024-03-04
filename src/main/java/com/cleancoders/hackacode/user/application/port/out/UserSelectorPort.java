package com.cleancoders.hackacode.user.application.port.out;

import com.cleancoders.hackacode.user.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserSelectorPort {
    User byId(Long id);
    User byEmail(String email);

    Page<User> getPage(Pageable pageable);
}
