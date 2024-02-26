package com.cleancoders.hackacode.client.application.port.out;

public interface ClientUtilsPort {

    boolean existsByUserEmail(String userEmail);
    boolean existsByUserId(Long userId);
    boolean existsById(Long id);
}
