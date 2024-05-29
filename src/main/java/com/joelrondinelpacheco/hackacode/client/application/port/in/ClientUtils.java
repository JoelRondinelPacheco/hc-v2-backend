package com.joelrondinelpacheco.hackacode.client.application.port.in;

public interface ClientUtils {
    void assertExistsByUserEmail(String userEmail);
    void assertDoesNotExistsByUserEmail(String userEmail);
    void assertExistsByUserId(Long userId);
    void assertDoesNotExistsByUserId(Long userId);
    void assertExistsById(Long id);
    void assertDoesNotExistsById(Long id);
}
