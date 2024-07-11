package com.joelrondinelpacheco.hackacode.common.domain;

public class LoadKeysException extends RuntimeException {
    public LoadKeysException(String message) {
        super(message);
    }

    public LoadKeysException(Throwable cause) {
        super(cause);
    }
}
