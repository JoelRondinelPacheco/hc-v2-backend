package com.joelrondinelpacheco.hackacode.common.application.exceptions;

public class LoadKeysException extends RuntimeException {
    public LoadKeysException(String message) {
        super(message);
    }

    public LoadKeysException(Throwable cause) {
        super(cause);
    }
}
