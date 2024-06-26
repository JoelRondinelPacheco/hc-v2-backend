package com.joelrondinelpacheco.hackacode.mail.application.usecases.impl;

import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.mail.application.dto.SendMailDTO;
import com.joelrondinelpacheco.hackacode.mail.application.port.input.MailService;
import com.joelrondinelpacheco.hackacode.mail.application.port.output.MailServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;

@UseCase
public class MailServiceImpl implements MailService {

    private final MailServicePort mailServicePort;

    @Autowired
    public MailServiceImpl(MailServicePort mailServicePort) {
        this.mailServicePort = mailServicePort;
    }

    @Override
    public String send(SendMailDTO mail) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        String response = "";
        try {
            this.mailServicePort.send(mailMessage);
            response = "Mail ok";
        } catch (MailException e) {
            response = "Mail error";
        } finally {
            return response;
        }
    }
}
