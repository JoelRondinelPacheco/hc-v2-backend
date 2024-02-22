package com.cleancoders.hackacode.service.application.port.out;

public interface CategoryUtilPort {

    boolean existsByName(String name);
    boolean existsById(Long id);
}
