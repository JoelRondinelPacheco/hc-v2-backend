package com.joelrondinelpacheco.hackacode.service.adapter.in.web;

import com.joelrondinelpacheco.hackacode.service.application.dto.EditServiceDTO;
import com.joelrondinelpacheco.hackacode.service.application.dto.NewServiceDTO;
import com.joelrondinelpacheco.hackacode.service.application.port.in.ServicePersistence;
import com.joelrondinelpacheco.hackacode.service.application.port.in.ServiceSelector;
import com.joelrondinelpacheco.hackacode.service.domain.ServiceData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service")
public class ServiceController {

    /*
    TODO Agregar atributos de multiplicador de servicio (ejm: aquiler es por dia, puede alquilar varios dias)
     */
    private final ServicePersistence servicePersistence;
    private final ServiceSelector serviceSelector;

    public ServiceController(ServicePersistence servicePersistence, ServiceSelector serviceSelector) {
        this.servicePersistence = servicePersistence;
        this.serviceSelector = serviceSelector;
    }


    @PostMapping
    public ResponseEntity<?> addService(@RequestBody NewServiceDTO serviceDTO) {
        return ResponseEntity.ok(this.servicePersistence.newService(serviceDTO));
    }

    @GetMapping
    public ResponseEntity<Page<ServiceData>> getAllServices(Pageable pageable) {
        Page<ServiceData> s = this.servicePersistence.getByPage(pageable);
        System.out.println(s);
        return ResponseEntity.ok(s);
    }

    @GetMapping("/{serviceId}")
    public ResponseEntity<ServiceData> getById(@PathVariable Long serviceId) {
        return ResponseEntity.ok(this.serviceSelector.byId(serviceId));
    }

    @PutMapping("/{serviceId}")
    public ResponseEntity<ServiceData> editService(@PathVariable Long serviceId, @RequestBody EditServiceDTO serviceDTO) {
        return ResponseEntity.ok(this.servicePersistence.update(serviceDTO));
    }

    @DeleteMapping("/{serviceId}")
    public ResponseEntity<?> deleteService(@PathVariable String serviceId) {
        return ResponseEntity.ok(this.servicePersistence.deleteService(serviceId));
    }
}
