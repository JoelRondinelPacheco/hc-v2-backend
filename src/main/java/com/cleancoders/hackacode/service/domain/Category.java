package com.cleancoders.hackacode.service.domain;

import java.util.List;

public class Category {
    private Long id;
    private String name;
    private String description;
    private List<Service> services;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Category setName(String name) {
        this.name = name;
        return this;
    }

    public Category setServices(List<Service> services) {
        this.services = services;
        return this;
    }
}
