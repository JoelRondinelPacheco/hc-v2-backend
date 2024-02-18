package com.cleancoders.hackacode.service.application.dto;

import com.cleancoders.hackacode.service.domain.Service;

public class CategoryDTOBase {
    private Service service;

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
