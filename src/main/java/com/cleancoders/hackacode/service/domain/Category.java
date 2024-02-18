package com.cleancoders.hackacode.service.domain;

public class Category {
    private Long id;
    private String name;
    private Service service;

    public String getName() {
        return name;
    }

    public Category setName(String name) {
        this.name = name;
        return this;
    }

    public Service getService() {
        return service;
    }

    public Category setService(Service service) {
        this.service = service;
        return this;
    }
}
