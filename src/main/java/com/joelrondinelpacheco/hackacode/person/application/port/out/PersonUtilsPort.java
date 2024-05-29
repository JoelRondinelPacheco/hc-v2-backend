package com.joelrondinelpacheco.hackacode.person.application.port.out;

public interface PersonUtilsPort {
    boolean existsByEmail(String email);
    boolean existsById(Long id);
}
