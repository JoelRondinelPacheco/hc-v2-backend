package com.cleancoders.hackacode.employee.application.usecases;

public interface EmployeeUtils {

    void assertExistsByUserEmail(String userEmail);
    void assertDoesNotExistsByUserEmail(String userEmail);
    void assertExistsByUserId(Long userId);
    void assertDoesNotExistsByUserId(Long userId);
}
