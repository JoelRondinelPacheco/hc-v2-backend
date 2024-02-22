package com.cleancoders.hackacode.user.application.port.in;

public interface UserUtils {
    void assertExistsByEmail(String email);
    void assertDoesNotExistsByEmail(String email);
    void assertExistsById(Long id);
    void assertDoesNotExistsById(Long id);
}
