package com.cleancoders.hackacode.security.application.port.out;

import com.cleancoders.hackacode.security.domain.Module;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ModuleSelectorPort {
    Page<Module> getPage(Pageable pageable);
}
