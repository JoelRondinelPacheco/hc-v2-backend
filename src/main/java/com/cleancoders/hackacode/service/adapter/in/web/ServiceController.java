package com.cleancoders.hackacode.service.adapter.in.web;

import com.cleancoders.hackacode.service.application.dto.NewServiceDTO;
import com.cleancoders.hackacode.service.application.port.in.ServicePersistence;
import com.cleancoders.hackacode.service.application.port.in.ServiceSelector;
import com.cleancoders.hackacode.service.domain.Category;
import com.cleancoders.hackacode.service.domain.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private ServiceSelector serviceSelector;
    @Autowired
    private ServicePersistence servicePersistence;

    @PostMapping
    public ResponseEntity<Service> addService(@RequestBody NewServiceDTO body) {
        return ResponseEntity.ok(this.servicePersistence.save(body));
    }

    @GetMapping
    public ResponseEntity<List<Service>> getAll(Pageable pageable) {
        Page<Service> services = this.serviceSelector.getAll(pageable);
        for (Service ser : services) {
            System.out.println(ser.toString());
        }
        return ResponseEntity.ok(this.serviceSelector.getAll(pageable).stream().toList());
    }

}
