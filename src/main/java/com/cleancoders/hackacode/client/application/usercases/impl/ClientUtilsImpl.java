package com.cleancoders.hackacode.client.application.usercases.impl;

import com.cleancoders.hackacode.client.application.port.in.ClientUtils;
import com.cleancoders.hackacode.client.application.port.out.ClientUtilsPort;
import com.cleancoders.hackacode.common.UseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.transform.impl.InterceptFieldFilter;

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
