package com.joelrondinelpacheco.hackacode.client.adapter.in.web;

import com.joelrondinelpacheco.hackacode.client.application.port.in.ClientByName;
import com.joelrondinelpacheco.hackacode.client.domain.Client;
import com.joelrondinelpacheco.hackacode.client.application.port.in.ClientPersistence;
import com.joelrondinelpacheco.hackacode.client.application.port.in.ClientSelector;
import com.joelrondinelpacheco.hackacode.person.application.dto.NewPersonDTO;
import com.joelrondinelpacheco.hackacode.users.application.dto.RegisterResponse;
import com.joelrondinelpacheco.hackacode.users.application.port.in.RegisterUserUseCase;
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
    private final RegisterUserUseCase registerUserUseCase;

    public ClientController(ClientSelector clientSelector, ClientPersistence clientPersistence, ClientByName clientByName, RegisterUserUseCase registerUserUseCase) {
        this.clientSelector = clientSelector;
        this.clientPersistence = clientPersistence;
        this.clientByName = clientByName;
        this.registerUserUseCase = registerUserUseCase;
    }

    @PostMapping
    public ResponseEntity<RegisterResponse> save(@RequestBody NewPersonDTO userInfo) {
    ///public ResponseEntity<RegisterResponse> save(@RequestBody TestR userInfo) {
        System.out.println("zdasd");
        System.out.println(userInfo);
        return ResponseEntity.ok(
                new RegisterResponse(
                        //this.registerUserUseCase.registerClient(userInfo)
                        "okk"
                )
        );
    }

    @GetMapping
    public ResponseEntity<Page<Client>> getClientsPaginated(Pageable pageable) {
        return ResponseEntity.ok(this.clientSelector.getClientsPaginated(pageable));
    }

    @GetMapping("/search")
    public ResponseEntity<Page<Client>> getClientByName(@RequestParam(value = "name") String name, Pageable pageable) {
        return ResponseEntity.ok(this.clientByName.get(name, pageable));
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<Client> getClientById(@PathVariable Long clientId) {
        return ResponseEntity.ok(this.clientSelector.byId(clientId));
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<?> deleteClient(@PathVariable Long clientId) {
        this.clientPersistence.delete(clientId);
        return ResponseEntity.ok("Eliminado");
    }
}
