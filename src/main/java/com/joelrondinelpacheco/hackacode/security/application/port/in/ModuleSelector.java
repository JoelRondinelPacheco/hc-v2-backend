package com.joelrondinelpacheco.hackacode.security.application.port.in;

import com.joelrondinelpacheco.hackacode.security.domain.Module;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ModuleSelector {
    Page<Module> getPage(Pageable pageable);
}
