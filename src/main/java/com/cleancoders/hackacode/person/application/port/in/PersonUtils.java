package com.cleancoders.hackacode.person.application.port.in;

public interface PersonUtils {
    void assertExistsByEmail(String email);
    void assertDoesNotExistsByEmail(String email);
    void assertExistsById(Long id);
    void assertDoesNotExistsById(Long id);
}
