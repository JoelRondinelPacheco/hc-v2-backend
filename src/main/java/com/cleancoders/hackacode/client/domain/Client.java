package com.cleancoders.hackacode.client.domain;

import com.cleancoders.hackacode.person.domain.Person;
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
