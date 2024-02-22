package com.cleancoders.hackacode.client.adapter.out.persistence;

import com.cleancoders.hackacode.client.application.port.out.ClientUtilsPort;
import com.cleancoders.hackacode.common.PersistenceAdapter;
import org.springframework.beans.factory.annotation.Autowired;

@PersistenceAdapter
public class ClientUtilsPersistenceAdapter implements ClientUtilsPort {

    @Autowired
    private ClientMySQLRepository clientRepository;


    @Override
    public boolean existsByUserEmail(String userEmail) {
        return this.clientRepository.existsByUser_Email(userEmail);
    }

    @Override
    public boolean existsByUserId(Long userId) {
        return this.clientRepository.existsByUser_Id(userId);
    }

}
