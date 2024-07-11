package com.joelrondinelpacheco.hackacode.common.domain;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}
