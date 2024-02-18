package com.cleancoders.hackacode.service.adapter.in.web;

import com.cleancoders.hackacode.service.application.dto.NewServiceDTO;
import com.cleancoders.hackacode.service.application.port.in.ServicePersistence;
import com.cleancoders.hackacode.service.application.port.in.ServiceSelector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/service")
public class ServiceController {

    @Autowired
    private ServiceSelector serviceSelector;
    @Autowired
    private ServicePersistence servicePersistence;

    @PostMapping
    public ResponseEntity<?> addService(@RequestBody NewServiceDTO body) {
        this.servicePersistence.save(body);
        return null;
    }

}
