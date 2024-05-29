package com.joelrondinelpacheco.hackacode.user.application.port.out;

public interface UserUtilsPort {
    boolean existsByUserId(Long id);
    boolean existsByUserEmail(String email);

    boolean existsById(Long id);
}
