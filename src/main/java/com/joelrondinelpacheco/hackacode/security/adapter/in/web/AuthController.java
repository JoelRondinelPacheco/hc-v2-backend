package com.joelrondinelpacheco.hackacode.security.adapter.in.web;

import com.joelrondinelpacheco.hackacode.person.application.dto.NewClientDTO;
import com.joelrondinelpacheco.hackacode.security.application.dto.auth.*;
import com.joelrondinelpacheco.hackacode.security.application.usecases.CookiesJWTUseCase;
import com.joelrondinelpacheco.hackacode.users.application.usecases.UserStarterUseCase;
import com.joelrondinelpacheco.hackacode.employee.application.port.in.RegisterEmployeeUseCase;
import com.joelrondinelpacheco.hackacode.security.application.usecases.AuthenticationUseCase;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationUseCase authService;
    private final UserStarterUseCase registerClientUserCase;
    private final RegisterEmployeeUseCase registerEmployeeUseCase;
    private final CookiesJWTUseCase createCookiesJWT;


    public AuthController(AuthenticationUseCase authService, UserStarterUseCase registerClientUserCase, RegisterEmployeeUseCase registerEmployeeUseCase, CookiesJWTUseCase createCookiesJWT) {
        this.authService = authService;
        this.registerClientUserCase = registerClientUserCase;
        this.registerEmployeeUseCase = registerEmployeeUseCase;
        this.createCookiesJWT = createCookiesJWT;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody NewClientDTO body) {
        //TODO implement
        return ResponseEntity.ok("Response");
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest body) {
        AuthenticationData auth = this.authService.login(body);

        AuthenticationResponse res = AuthenticationResponse.builder()
                .name(auth.getName())
                .email(auth.getEmail())
                .role(auth.getRole())
                .build();

        ResponseCookie refreshJwtCookie = createCookiesJWT.refreshJwtCookie(auth.getRefreshToken());
        res.setAuthToken(auth.getAuthToken());
        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, refreshJwtCookie.toString())
                .body(res);
    }

    @PostMapping("/refresh")
    public ResponseEntity<Token> refreshToken(HttpServletRequest req) {
        return ResponseEntity.ok(this.authService.refreshAuthToken(req));
    }

    @PostMapping("/logout")
    public ResponseEntity<LogoutResponse> logout(HttpServletRequest request) {
        this.authService.logout(request);
        return ResponseEntity.ok(null);
    }
}
