package com.cleancoders.hackacode.client.application.port.in;

public interface ClientUtils {
    void assertExistsByUserEmail(String userEmail);
    void assertDoesNotExistsByUserEmail(String userEmail);
    void assertExistsByUserId(Long userId);
    void assertDoesNotExistsByUserId(Long userId);
}
