package com.cleancoders.hackacode.user.application.usecases;

public interface EmployeeUtils {

    void assertExistsByUserEmail(String userEmail);
    void assertDoesNotExistsByUserEmail(String userEmail);
    void assertExistsByUserId(Long userId);
    void assertDoesNotExistsByUserId(Long userId);
    void assertExistsById(Long userId);
    void assertDoesNotExistsById(Long userId);

    String createRandomPassword();
}
