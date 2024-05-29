package com.joelrondinelpacheco.hackacode.user.application.port.out;

import com.joelrondinelpacheco.hackacode.user.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserSelectorPort {
    User byId(Long id);
    User byEmail(String email);

    Page<User> getPage(Pageable pageable);
}
