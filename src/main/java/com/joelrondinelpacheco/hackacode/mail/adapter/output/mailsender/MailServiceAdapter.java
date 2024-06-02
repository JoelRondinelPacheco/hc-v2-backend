package com.joelrondinelpacheco.hackacode.mail.adapter.output.mailsender;

import com.joelrondinelpacheco.hackacode.mail.application.port.output.MailServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailServiceAdapter implements MailServicePort {

    private final JavaMailSender mailSender;

    @Autowired
    public MailServiceAdapter(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public String send(SimpleMailMessage mail) {
        this.mailSender.send(mail);
        return null;
    }
}
