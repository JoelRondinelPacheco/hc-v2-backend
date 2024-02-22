package com.cleancoders.hackacode.user.application.port.out;

public interface UserUtilsPort {
    boolean existsByUserId(Long id);
    boolean existsByUserEmail(String email);
}
