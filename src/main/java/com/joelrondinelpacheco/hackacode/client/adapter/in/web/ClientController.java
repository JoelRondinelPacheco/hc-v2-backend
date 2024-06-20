package com.joelrondinelpacheco.hackacode.client.adapter.in.web;

import com.joelrondinelpacheco.hackacode.client.application.port.in.ClientByName;
import com.joelrondinelpacheco.hackacode.client.domain.Client;
import com.joelrondinelpacheco.hackacode.person.application.dto.NewPersonDTO;
import com.joelrondinelpacheco.hackacode.client.application.port.in.ClientPersistence;
import com.joelrondinelpacheco.hackacode.client.application.port.in.ClientSelector;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {


    private final ClientSelector clientSelector;
    private final ClientPersistence clientPersistence;
    private final ClientByName clientByName;

    public ClientController(ClientSelector clientSelector, ClientPersistence clientPersistence, ClientByName clientByName) {
        this.clientSelector = clientSelector;
        this.clientPersistence = clientPersistence;
        this.clientByName = clientByName;
    }

    @PostMapping
    private ResponseEntity<Client> save(@RequestBody NewPersonDTO userInfo) {
        //TODO IMPLEMENT
        //return ResponseEntity.ok(this.clientPersistence.createClient(userInfo));
        return null;
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
    private ResponseEntity<Client> getClientById(@PathVariable Long clientId) {
        return ResponseEntity.ok(this.clientSelector.byId(clientId));
    }

    @DeleteMapping("/{clientId}")
    private ResponseEntity<?> deleteClient(@PathVariable Long clientId) {
        this.clientPersistence.delete(clientId);
        return ResponseEntity.ok("Eliminado");
    }
}
