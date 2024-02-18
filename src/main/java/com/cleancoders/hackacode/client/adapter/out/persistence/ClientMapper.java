package com.cleancoders.hackacode.client.adapter.out.persistence;

import com.cleancoders.hackacode.client.domain.Client;
import com.cleancoders.hackacode.common.adapter.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("clientMapper")
public class ClientMapper implements Mapper {
    @Override
    public Object entityToDomain(Object o) {
        return null;
    }

    @Override
    public Object domainToEntity(Object o) {
        return null;
    }
}
