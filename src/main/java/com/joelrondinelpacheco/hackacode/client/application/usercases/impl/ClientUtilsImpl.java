package com.joelrondinelpacheco.hackacode.client.application.usercases.impl;

import com.joelrondinelpacheco.hackacode.client.application.port.in.ClientUtils;
import com.joelrondinelpacheco.hackacode.client.application.port.out.ClientUtilsPort;
import com.joelrondinelpacheco.hackacode.common.UseCase;
import org.springframework.beans.factory.annotation.Autowired;

@UseCase
public class ClientUtilsImpl implements ClientUtils {

    @Autowired
    private ClientUtilsPort clientRepository;


    @Override
    public void assertExistsByUserEmail(String userEmail) {
        if (!this.clientRepository.existsByUserEmail(userEmail)) {
            throw new RuntimeException("TODO");
        }
    }

    @Override
    public void assertDoesNotExistsByUserEmail(String userEmail) {
        if (this.clientRepository.existsByUserEmail(userEmail)) {
            throw new RuntimeException("TODO");
        }
    }

    @Override
    public void assertExistsByUserId(Long userId) {
        if (!this.clientRepository.existsByUserId(userId)) {
            throw new RuntimeException("TODO");
        }
    }

    @Override
    public void assertDoesNotExistsByUserId(Long userId) {
        if (this.clientRepository.existsByUserId(userId)) {
            throw new RuntimeException("TODO");
        }
    }

    @Override
    public void assertExistsById(Long id) {
        if (!this.clientRepository.existsById(id)) {
            throw new RuntimeException("TODO");
        }
    }

    @Override
    public void assertDoesNotExistsById(Long id) {
        if (this.clientRepository.existsById(id)) {
            throw new RuntimeException("TODO");
        }
    }
}
