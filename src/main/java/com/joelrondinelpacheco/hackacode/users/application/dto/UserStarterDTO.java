package com.joelrondinelpacheco.hackacode.users.application.dto;

import com.joelrondinelpacheco.hackacode.person.domain.Person;
import com.joelrondinelpacheco.hackacode.security.domain.UserCredentialsReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserStarterDTO {
    private Person person;
    private UserCredentialsReference userCredentials;
}
