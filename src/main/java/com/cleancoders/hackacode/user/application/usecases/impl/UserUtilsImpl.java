package com.cleancoders.hackacode.user.application.usecases.impl;

import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.user.application.port.in.UserUtils;
import com.cleancoders.hackacode.user.application.port.out.UserUtilsPort;
import org.springframework.beans.factory.annotation.Autowired;

@UseCase
public class UserUtilsImpl implements UserUtils {

    @Autowired
    private UserUtilsPort userUtilsRepository;

    @Override
    public void assertExistsByEmail(String email) {
        /*
        true no lanza nada

        false lanza
         */
        if (!this.userUtilsRepository.existsByEmail(email)) {
            throw new RuntimeException("TODO");
        }
    }

    @Override
    public void assertDoesNotExistsByEmail(String email) {
        /*
        true lanza
        false no lanza
        la entidad ya existe, si es falso esta todo bien pq no existe
         */
        if (this.userUtilsRepository.existsByEmail(email)) {
            throw new RuntimeException("TODO");
        }
    }

    @Override
    public void assertExistsById(Long id) {
        if (!this.userUtilsRepository.existsById(id)) {
            throw new RuntimeException("TODO");
        }
    }

    @Override
    public void assertDoesNotExistsById(Long id) {
        if (this.userUtilsRepository.existsById(id)) {
            throw new RuntimeException("TODO");
        }
    }

}
