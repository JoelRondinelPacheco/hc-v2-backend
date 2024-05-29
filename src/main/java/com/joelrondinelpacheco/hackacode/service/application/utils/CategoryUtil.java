package com.joelrondinelpacheco.hackacode.service.application.utils;

public interface CategoryUtil {
    void assertCategoryDoesNotExistByName(String name);

    void assertCategoryExistsById(Long id);
}
