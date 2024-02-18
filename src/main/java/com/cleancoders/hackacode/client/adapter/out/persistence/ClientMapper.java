package com.cleancoders.hackacode.client.adapter.out.persistence;

import com.cleancoders.hackacode.client.domain.Client;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {


    public static Client entityToDomain(ClientEntity clientEntity) {
        return new Client(clientEntity.getUser());
    }

    public static ClientEntity domainToEntity(Client client) {
        return null;
    }
}
