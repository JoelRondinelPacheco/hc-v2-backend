package com.cleancoders.hackacode.utils.adapter.out.persistence;

import com.cleancoders.hackacode.client.adapter.out.persistence.ClientEntity;

import java.util.Optional;

public class OptionalCheckerImpl implements OptionalChecker<ClientEntity, RuntimeException> {
    @Override
    public ClientEntity check(Optional<ClientEntity> optional) {
        return null;
    }
}
