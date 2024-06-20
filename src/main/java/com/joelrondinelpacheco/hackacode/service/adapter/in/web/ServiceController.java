package com.joelrondinelpacheco.hackacode.service.adapter.in.web;

import com.joelrondinelpacheco.hackacode.service.application.dto.EditServiceDTO;
import com.joelrondinelpacheco.hackacode.service.application.dto.NewServiceDTO;
import com.joelrondinelpacheco.hackacode.service.application.port.in.ServicePersistence;
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

    public ServiceController(ServicePersistence servicePersistence) {
        this.servicePersistence = servicePersistence;
    }


    @PostMapping
    public ResponseEntity<?> addService(@RequestBody NewServiceDTO serviceDTO) {
        return ResponseEntity.ok(this.servicePersistence.newService(serviceDTO));
    }

    @GetMapping
    public ResponseEntity<Page<ServiceData>> getAllServices(Pageable pageable) {
        return ResponseEntity.ok(this.servicePersistence.getByPage(pageable));
    }

    @PutMapping("/{serviceId}")
    public ResponseEntity<?> editService(@PathVariable EditServiceDTO serviceDTO) {
        return ResponseEntity.ok(this.servicePersistence.update(serviceDTO));
    }

    @DeleteMapping("/{serviceId}")
    public ResponseEntity<?> deleteService(@PathVariable String serviceId) {
        return ResponseEntity.ok(this.servicePersistence.deleteService(serviceId));
    }
}
