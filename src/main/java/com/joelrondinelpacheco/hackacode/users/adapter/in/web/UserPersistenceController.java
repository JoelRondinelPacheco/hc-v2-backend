package com.joelrondinelpacheco.hackacode.users.adapter.in.web;

import com.joelrondinelpacheco.hackacode.employee.application.dto.NewEmployeeDTO;
import com.joelrondinelpacheco.hackacode.person.application.dto.NewPersonDTO;
import com.joelrondinelpacheco.hackacode.users.application.port.in.RegisterUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<?> registerClient(@RequestBody NewPersonDTO body) {
        return ResponseEntity.ok(this.registerUserUseCase.registerClient(body));
    }

    @PostMapping("/employee")
    public ResponseEntity<?> registerEmployee(@RequestBody NewEmployeeDTO body) {
        return ResponseEntity.ok(this.registerUserUseCase.registerEmployee(body));
    }


}
