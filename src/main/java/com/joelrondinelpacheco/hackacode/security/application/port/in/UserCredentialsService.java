package com.joelrondinelpacheco.hackacode.security.application.port.in;

import com.joelrondinelpacheco.hackacode.person.domain.Person;
import com.joelrondinelpacheco.hackacode.security.domain.UserCredentials;
import com.joelrondinelpacheco.hackacode.security.domain.UserCredentialsReference;

public interface UserCredentialsService {
    UserCredentialsReference newUserCredentialsReference(Person person, Long roleId, String password);
    UserCredentials saveUserCredentials(UserCredentials userCredentials);
    void enableAccountByEmailConfirmation();
    void disableAccount();
    void verifyCredentialsNonExpired(UserCredentials credentials);

    void verifyAccountNonLocked(UserCredentials userCredentials);
}
