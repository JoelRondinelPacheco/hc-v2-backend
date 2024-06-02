package com.joelrondinelpacheco.hackacode.mail.application.port.input;

import org.springframework.mail.SimpleMailMessage;

public interface MailService {
    String send(SimpleMailMessage mail);

}
