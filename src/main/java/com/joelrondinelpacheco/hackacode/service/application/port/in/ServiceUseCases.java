package com.joelrondinelpacheco.hackacode.service.application.port.in;

import com.joelrondinelpacheco.hackacode.service.domain.Category;

public interface ServiceUseCases {
    Category addCategory(String name);
    String deleteCategory(String name);
    Category editCategory(String name);
}
