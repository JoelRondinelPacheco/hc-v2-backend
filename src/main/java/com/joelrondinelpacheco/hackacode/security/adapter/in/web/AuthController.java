package com.joelrondinelpacheco.hackacode.security.adapter.in.web;

import com.joelrondinelpacheco.hackacode.person.application.dto.NewClientDTO;
import com.joelrondinelpacheco.hackacode.security.application.dto.auth.AuthenticationRequest;
import com.joelrondinelpacheco.hackacode.security.application.dto.auth.AuthenticationResponse;
import com.joelrondinelpacheco.hackacode.security.application.dto.auth.LogoutResponse;
import com.joelrondinelpacheco.hackacode.security.application.dto.auth.Token;
import com.joelrondinelpacheco.hackacode.users.application.usecases.UserStarterUseCase;
import com.joelrondinelpacheco.hackacode.employee.application.port.in.RegisterEmployeeUseCase;
import com.joelrondinelpacheco.hackacode.security.application.usecases.AuthenticationUseCase;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationUseCase authService;
    private final UserStarterUseCase registerClientUserCase;
    private final RegisterEmployeeUseCase registerEmployeeUseCase;

    public AuthController(AuthenticationUseCase authService, UserStarterUseCase registerClientUserCase, RegisterEmployeeUseCase registerEmployeeUseCase) {
        this.authService = authService;
        this.registerClientUserCase = registerClientUserCase;
        this.registerEmployeeUseCase = registerEmployeeUseCase;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody NewClientDTO body) {
        //TODO implement
        return ResponseEntity.ok("Response");
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest body) {
        System.out.println(body);
        return ResponseEntity.ok(this.authService.login(body));
    }

    @PostMapping("/refresh")
    public ResponseEntity<Token> refreshToken(@RequestBody Token req) {
        System.out.println(req);
        return ResponseEntity.ok(new Token("asd"));
    }

    @PostMapping("/logout")
    public ResponseEntity<LogoutResponse> logout(HttpServletRequest request) {
        this.authService.logout(request);
        return ResponseEntity.ok(null);
    }
}
