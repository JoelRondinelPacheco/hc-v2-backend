package com.cleancoders.hackacode.client.application.usercases.impl;

import com.cleancoders.hackacode.user.application.dto.NewUserDTO;
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
    public Client newClient(NewUserDTO userDTO) {
        //DESDE CERO
        this.userUtils.assertDoesNotExistsByEmail(userDTO.getEmail());
        //TODO VER SI ES NECESARIO
        this.clientUtils.assertDoesNotExistsByUserEmail(userDTO.getEmail());

        //CREAR USER
        //CREA CLIENT Y LE ASIGNA USER
        //TODO IMPL
        User user = this.userRepository.save(this.userBuilder.userFromDTO(userDTO));

        Client client = new Client();
        client.setUserId(user.getId());

        //TODO IMPL
        return this.clientRepository.save(client);
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
