package com.cleancoders.hackacode.security.adapter.in.web;

import com.cleancoders.hackacode.security.application.dto.auth.AuthenticationRequest;
import com.cleancoders.hackacode.security.application.dto.auth.AuthenticationResponse;
import com.cleancoders.hackacode.security.application.dto.auth.LogoutResponse;
import com.cleancoders.hackacode.security.application.usecases.AuthenticationUseCase;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationUseCase authService;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest body) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException {

        return ResponseEntity.ok(this.authService.login(body));
    }

    @PostMapping("/logout")
    public ResponseEntity<LogoutResponse> logout(HttpServletRequest request) {
        this.authService.logout(request);
        return ResponseEntity.ok(null);
    }
}
