package com.joelrondinelpacheco.hackacode.mail.application.port.output;

import org.springframework.mail.SimpleMailMessage;

public interface MailServicePort {

    String send(SimpleMailMessage mailDTO);

}
