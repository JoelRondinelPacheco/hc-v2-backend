package com.joelrondinelpacheco.hackacode.client.adapter.out.persistence;

import com.joelrondinelpacheco.hackacode.client.application.port.out.ClientUtilsPort;
import com.joelrondinelpacheco.hackacode.common.PersistenceAdapter;
import org.springframework.beans.factory.annotation.Autowired;

@PersistenceAdapter
public class ClientUtilsPersistenceAdapter implements ClientUtilsPort {

    @Autowired
    private ClientMySQLRepository clientRepository;

    @Override
    public boolean existsByUserEmail(String userEmail) {
        return this.clientRepository.existsByPerson_Email(userEmail);
    }

    @Override
    public boolean existsByUserId(Long userId) {
        return this.clientRepository.existsByPerson_Id(userId);
    }

    @Override
    public boolean existsById(Long id) {
        return this.clientRepository.existsById(id);
    }

}
