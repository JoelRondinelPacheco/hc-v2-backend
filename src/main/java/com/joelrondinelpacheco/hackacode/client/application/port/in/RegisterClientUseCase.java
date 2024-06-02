package com.joelrondinelpacheco.hackacode.client.application.port.in;

import com.joelrondinelpacheco.hackacode.person.application.dto.NewPersonDTO;

public interface RegisterClientUseCase {
    void createClient(NewPersonDTO body);
}
