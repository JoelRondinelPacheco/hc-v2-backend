package com.cleancoders.hackacode.user.application.port.out;

public interface UserUtilsPort {
    boolean existsByEmail(String email);
    boolean existsById(Long id);
}
