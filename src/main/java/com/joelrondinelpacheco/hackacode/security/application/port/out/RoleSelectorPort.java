package com.joelrondinelpacheco.hackacode.security.application.port.out;

import com.joelrondinelpacheco.hackacode.security.domain.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RoleSelectorPort {

    Page<Role> getAll(Pageable pageable);

    Role getByName(String name);
    Role findById(Long id);


}
