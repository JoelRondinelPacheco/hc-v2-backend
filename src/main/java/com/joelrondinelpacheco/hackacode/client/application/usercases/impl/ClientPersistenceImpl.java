package com.joelrondinelpacheco.hackacode.client.application.usercases.impl;

import com.joelrondinelpacheco.hackacode.person.application.dto.NewPersonDTO;
import com.joelrondinelpacheco.hackacode.client.application.port.in.ClientPersistence;
import com.joelrondinelpacheco.hackacode.client.application.port.in.ClientUtils;
import com.joelrondinelpacheco.hackacode.client.application.port.out.ClientPersistencePort;
import com.joelrondinelpacheco.hackacode.client.domain.Client;
import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.person.application.port.in.PersonPersistence;
import com.joelrondinelpacheco.hackacode.person.application.port.in.PersonUtils;
import com.joelrondinelpacheco.hackacode.person.application.usecases.PersonBuilder;
import com.joelrondinelpacheco.hackacode.person.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;

@UseCase
public class ClientPersistenceImpl implements ClientPersistence {

    @Autowired
    private ClientPersistencePort clientRepository;
    @Autowired
    private PersonPersistence userRepository;

    @Autowired
    private PersonUtils personUtils;
    @Autowired
    private ClientUtils clientUtils;
    @Autowired
    private PersonBuilder personBuilder;

    @Override
    public Client newClient(NewPersonDTO userDTO) {
        //DESDE CERO
        this.personUtils.assertDoesNotExistsByEmail(userDTO.getEmail());
        //TODO VER SI ES NECESARIO
        this.clientUtils.assertDoesNotExistsByUserEmail(userDTO.getEmail());

        //CREAR USER
        //CREA CLIENT Y LE ASIGNA USER
        //TODO IMPL
        Person person = this.userRepository.save(userDTO);

        Client client = new Client();
        client.setPerson(person);

        return this.clientRepository.save(client);
    }

    @Override
    public Client update() {
        return null;
    }

    @Override
    public String delete(Long id) {
        return null;
    }
}
