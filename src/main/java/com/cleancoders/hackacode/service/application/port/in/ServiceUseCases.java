package com.cleancoders.hackacode.service.application.port.in;

import com.cleancoders.hackacode.service.domain.Category;

public interface ServiceUseCases {
    Category addCategory(String name);
    String deleteCategory(String name);
    Category editCategory(String name);
}
