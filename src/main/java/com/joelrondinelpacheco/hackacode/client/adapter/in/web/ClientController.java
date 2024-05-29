package com.joelrondinelpacheco.hackacode.client.adapter.in.web;

import com.joelrondinelpacheco.hackacode.client.application.port.in.ClientByName;
import com.joelrondinelpacheco.hackacode.client.domain.Client;
import com.joelrondinelpacheco.hackacode.person.application.dto.NewPersonDTO;
import com.joelrondinelpacheco.hackacode.client.application.port.in.ClientPersistence;
import com.joelrondinelpacheco.hackacode.client.application.port.in.ClientSelector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientSelector clientSelector;
    @Autowired
    private ClientPersistence clientPersistence;
    @Autowired
    private ClientByName clientByName;

    @PostMapping
    private ResponseEntity<Client> save(@RequestBody NewPersonDTO userInfo) {
        return ResponseEntity.ok(this.clientPersistence.newClient(userInfo));
    }

    @GetMapping
    private ResponseEntity<Page<Client>> getClientsPaginated(Pageable pageable) {
        return ResponseEntity.ok(this.clientSelector.getClientsPaginated(pageable));
    }

    @GetMapping("/search")
    private ResponseEntity<Page<Client>> getClientByName(@RequestParam(value = "name") String name, Pageable pageable) {
        return ResponseEntity.ok(this.clientByName.get(name, pageable));
    }

    @GetMapping("/{clientId}")
    private ResponseEntity<Client> editClient(@PathVariable Long clientId) {
        return ResponseEntity.ok(this.clientSelector.byId(clientId));
    }

    @DeleteMapping("/{clientId}")
    private ResponseEntity<?> deleteClient(@PathVariable Long clientId) {
        this.clientPersistence.delete(clientId);
        return ResponseEntity.ok("Eliminado");
    }
}
