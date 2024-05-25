package com.cleancoders.hackacode.security.application.usecases.impl;

import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.security.application.port.in.ModuleSelector;
import com.cleancoders.hackacode.security.application.port.out.ModuleSelectorPort;
import com.cleancoders.hackacode.security.domain.Module;
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
