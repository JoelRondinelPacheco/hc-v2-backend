package com.joelrondinelpacheco.hackacode.mail.application.port.input;

import com.joelrondinelpacheco.hackacode.mail.application.dto.SendMailDTO;
import org.springframework.mail.SimpleMailMessage;

public interface MailService {
    String send(SendMailDTO mail);

}
