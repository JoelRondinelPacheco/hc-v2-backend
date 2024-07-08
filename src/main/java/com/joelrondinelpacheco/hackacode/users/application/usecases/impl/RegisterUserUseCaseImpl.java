package com.joelrondinelpacheco.hackacode.users.application.usecases.impl;

import com.joelrondinelpacheco.hackacode.client.application.port.in.ClientPersistence;
import com.joelrondinelpacheco.hackacode.client.domain.Client;
import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.employee.application.dto.NewEmployeeDTO;
import com.joelrondinelpacheco.hackacode.employee.application.port.in.EmployeePersistence;
import com.joelrondinelpacheco.hackacode.employee.domain.Employee;
import com.joelrondinelpacheco.hackacode.mail.application.port.input.MailService;
import com.joelrondinelpacheco.hackacode.person.application.dto.NewClientDTO;
import com.joelrondinelpacheco.hackacode.users.application.dto.UserStarterDTO;
import com.joelrondinelpacheco.hackacode.users.application.port.in.RegisterUserUseCase;
import com.joelrondinelpacheco.hackacode.users.application.usecases.UserStarterUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@UseCase
public class RegisterUserUseCaseImpl implements RegisterUserUseCase {

        //TODO ver si crear otro metodo que solo registere,y uno que tambien envie emails

    private final UserStarterUseCase userStarterUseCase;
    private final MailService mailService;
    private final ClientPersistence clientPersistence;
    private final EmployeePersistence employeePersistence;

    @Autowired
    public RegisterUserUseCaseImpl(UserStarterUseCase userStarterUseCase, MailService mailService, ClientPersistence clientPersistence, EmployeePersistence employeePersistence) {
        this.userStarterUseCase = userStarterUseCase;
        this.mailService = mailService;
        this.clientPersistence = clientPersistence;
        this.employeePersistence = employeePersistence;
    }

    @Override
    @Transactional
    public String registerClient(NewClientDTO body) {
        //TODO cambiar como se obtiene el rol
        UserStarterDTO userStarter = this.userStarterUseCase.createPersonStarterFromAdmin(body, 1L);
        Client client = this.clientPersistence.saveClient(userStarter);

        //  TODO refactor
        /*
        this.mailService.send(
                SendMailDTO.builder()
                        .token(userStarter.getToken())
                        .mailType(MailType.NEW_ACCOUNT)
                        .build()
        );*/

        return this.getRegisterOkMessage();

    }

    @Override
    @Transactional
    public String registerEmployee(NewEmployeeDTO employeeDTO) {
        UserStarterDTO userStarter = this.userStarterUseCase.createPersonStarterFromAdmin(employeeDTO, 2L);

        Employee employeeSaved = this.employeePersistence.saveEmployee(userStarter, employeeDTO.getSalary());

        //  TODO refactor
        /*
        this.mailService.send(
                SendMailDTO.builder()
                        .token(userStarter.getToken())
                        .mailType(MailType.NEW_ACCOUNT)
                        .build()
        );*/

        return this.getRegisterOkMessage();
    }

    private String getRegisterOkMessage() {
        return "Mail ok, revise su correo";
    }

    private NewClientDTO getNewPersonDTO(NewEmployeeDTO employee) {
        return NewClientDTO.builder()
                .email(employee.getEmail())
                .build();
    }

    private String generateRandomPassword() {
        return "secret_password";
    }
}
