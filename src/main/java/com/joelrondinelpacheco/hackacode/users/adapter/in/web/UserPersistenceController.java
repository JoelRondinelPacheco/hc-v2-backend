package com.joelrondinelpacheco.hackacode.users.adapter.in.web;

import com.joelrondinelpacheco.hackacode.employee.application.dto.NewEmployeeDTO;
import com.joelrondinelpacheco.hackacode.person.application.dto.NewClientDTO;
import com.joelrondinelpacheco.hackacode.users.application.dto.RegisterResponse;
import com.joelrondinelpacheco.hackacode.users.application.port.in.RegisterUserUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class UserPersistenceController {

    private final RegisterUserUseCase registerUserUseCase;

    public UserPersistenceController(RegisterUserUseCase registerUserUseCase) {
        this.registerUserUseCase = registerUserUseCase;
    }

    @PostMapping("/client")
    public ResponseEntity<RegisterResponse> registerClient(@RequestBody NewClientDTO body) {
        return ResponseEntity.ok(
                new RegisterResponse(this.registerUserUseCase.registerClient(body))
        );
    }

    @PostMapping("/employee")
    public ResponseEntity<RegisterResponse> registerEmployee(@RequestBody NewEmployeeDTO body) {
        return ResponseEntity.ok(
                new RegisterResponse(this.registerUserUseCase.registerEmployee(body))
        );
    }


}
