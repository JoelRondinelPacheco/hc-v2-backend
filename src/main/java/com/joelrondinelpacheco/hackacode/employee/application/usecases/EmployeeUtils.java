package com.joelrondinelpacheco.hackacode.employee.application.usecases;

public interface EmployeeUtils {

    void assertExistsByUserEmail(String userEmail);
    void assertDoesNotExistsByUserEmail(String userEmail);
    void assertExistsByUserId(Long userId);
    void assertDoesNotExistsByUserId(Long userId);
    void assertExistsById(Long userId);
    void assertDoesNotExistsById(Long userId);

    String createRandomPassword();
}
