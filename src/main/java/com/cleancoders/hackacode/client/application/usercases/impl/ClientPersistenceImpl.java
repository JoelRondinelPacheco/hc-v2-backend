package com.cleancoders.hackacode.client.application.usercases.impl;

import com.cleancoders.hackacode.client.application.dto.NewUserDTO;
import com.cleancoders.hackacode.client.application.port.in.ClientPersistence;
import com.cleancoders.hackacode.client.application.port.in.ClientUtils;
import com.cleancoders.hackacode.client.application.port.out.ClientPersistencePort;
import com.cleancoders.hackacode.client.domain.Client;
import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.user.application.port.in.UserPersistence;
import com.cleancoders.hackacode.user.application.port.in.UserUtils;
import com.cleancoders.hackacode.user.application.usecases.UserBuilder;
import com.cleancoders.hackacode.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

@UseCase
public class ClientPersistenceImpl implements ClientPersistence {

    @Autowired
    private ClientPersistencePort clientRepository;
    @Autowired
    private UserPersistence userRepository;

    @Autowired
    private UserUtils userUtils;
    @Autowired
    private ClientUtils clientUtils;
    @Autowired
    private UserBuilder userBuilder;

    @Override
    public Client save(NewUserDTO userDTO) {

        this.userUtils.existsByEmail(userDTO.getEmail());
        this.clientUtils.existsByUserEmail(userDTO.getEmail());

        User user = this.userRepository.save(this.userBuilder.userFromDTO(userDTO));

        return this.clientRepository.save(Client.withUser(user));
    }

    @Override
    public Client update() {
        return null;
    }

    @Override
    public String delete() {
        return null;
    }
}
