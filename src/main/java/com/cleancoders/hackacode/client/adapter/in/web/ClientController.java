package com.cleancoders.hackacode.client.adapter.in.web;

import com.cleancoders.hackacode.client.domain.Client;
import com.cleancoders.hackacode.person.application.dto.NewPersonDTO;
import com.cleancoders.hackacode.client.application.port.in.ClientPersistence;
import com.cleancoders.hackacode.client.application.port.in.ClientSelector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientSelector clientSelector;
    @Autowired
    private ClientPersistence clientPersistence;

    @PostMapping
    private ResponseEntity<Client> save(@RequestBody NewPersonDTO userInfo) {
        return ResponseEntity.ok(this.clientPersistence.newClient(userInfo));
    }

    @GetMapping
    private ResponseEntity<Page<Client>> getClientsPaginated(Pageable pageable) {
        return ResponseEntity.ok(this.clientSelector.getClientsPaginated(pageable));
    }

    @PutMapping("/{clientId}")
    private ResponseEntity<Client> editClient(@PathVariable String clientId) {
        return null;
    }

    @DeleteMapping("/{clientId}")
    private ResponseEntity<?> deleteClient(@PathVariable String clientId) {
        return null;
    }
}
