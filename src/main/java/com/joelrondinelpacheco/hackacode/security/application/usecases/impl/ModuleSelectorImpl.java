package com.joelrondinelpacheco.hackacode.security.application.usecases.impl;

import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.security.application.port.in.ModuleSelector;
import com.joelrondinelpacheco.hackacode.security.application.port.out.ModuleSelectorPort;
import com.joelrondinelpacheco.hackacode.security.domain.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@UseCase
public class ModuleSelectorImpl implements ModuleSelector {

    @Autowired
    private ModuleSelectorPort moduleSelectorPort;

    @Override
    public Page<Module> getPage(Pageable pageable) {
        return this.moduleSelectorPort.getPage(pageable);
    }
}
