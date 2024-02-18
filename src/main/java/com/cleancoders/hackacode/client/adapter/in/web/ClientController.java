package com.cleancoders.hackacode.client.adapter.in.web;

import com.cleancoders.hackacode.client.application.dto.NewUserDTO;
import com.cleancoders.hackacode.client.application.port.in.ClientPersistence;
import com.cleancoders.hackacode.client.application.port.in.ClientSelector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientSelector clientSelector;
    @Autowired
    private ClientPersistence clientPersistence;

    @PostMapping
    private ResponseEntity<String> save(@RequestBody NewUserDTO userInfo) {
        this.clientPersistence.save(userInfo);
        return ResponseEntity.ok("");
    }
}
