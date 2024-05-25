package com.cleancoders.hackacode.user.application.port.in;

import com.cleancoders.hackacode.user.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserSelector {
    User byId(Long id);
    User byEmail(String email);

    Page<User> getPage(Pageable pageable);
}
