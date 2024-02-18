package com.cleancoders.hackacode.client.application.usercases.impl;

import com.cleancoders.hackacode.client.application.port.in.ClientUtils;
import com.cleancoders.hackacode.client.application.port.out.ClientUtilsPort;
import com.cleancoders.hackacode.common.UseCase;
import org.springframework.beans.factory.annotation.Autowired;

@UseCase
public class ClientUtilsImpl implements ClientUtils {

    @Autowired
    private ClientUtilsPort clientRepository;

    @Override
    public void existsByUserEmail(String userEmail) {
        if(this.clientRepository.existsByUserEmail(userEmail)) {
            throw new RuntimeException("TODO CUSTOM EX");
        }
    }
}
