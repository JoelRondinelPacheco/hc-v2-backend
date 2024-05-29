package com.joelrondinelpacheco.hackacode.client.domain;

import com.joelrondinelpacheco.hackacode.person.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Client {
    private Long id;
    private Person person;
}
