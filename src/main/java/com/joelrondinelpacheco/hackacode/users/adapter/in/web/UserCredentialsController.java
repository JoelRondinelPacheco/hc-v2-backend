package com.joelrondinelpacheco.hackacode.users.adapter.in.web;

import com.joelrondinelpacheco.hackacode.users.application.port.in.VerifyAccountUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/credential")
public class UserCredentialsController {
    private final VerifyAccountUseCase verifyAccountUseCase;

    @Autowired
    public UserCredentialsController(VerifyAccountUseCase verifyAccountUseCase) {
        this.verifyAccountUseCase = verifyAccountUseCase;
    }

    @PostMapping("/verify/{token}")
    public ResponseEntity<?> verifyEmail(@PathVariable String token) {
        return ResponseEntity.ok(this.verifyAccountUseCase.verify(token));
    }

    /*
    TODO
    FORGOT PASSWORD
    CHANGE PASSWORD
     */
}
