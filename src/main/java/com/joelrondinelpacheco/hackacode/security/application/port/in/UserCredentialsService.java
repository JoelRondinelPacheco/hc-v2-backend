package com.joelrondinelpacheco.hackacode.security.application.port.in;

import com.joelrondinelpacheco.hackacode.person.domain.Person;
import com.joelrondinelpacheco.hackacode.security.domain.Role;
import com.joelrondinelpacheco.hackacode.security.domain.UserCredentials;

public interface UserCredentialsService {
    UserCredentials newUserCredentials(Person person, Role role, String password);
    UserCredentials saveUserCredentials(UserCredentials userCredentials);
    void enableAccountByEmailConfirmation();
    void disableAccount();
}
