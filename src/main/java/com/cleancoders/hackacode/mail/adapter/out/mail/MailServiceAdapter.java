package com.cleancoders.hackacode.mail.adapter.out.mail;

import com.cleancoders.hackacode.common.PersistenceAdapter;
import com.cleancoders.hackacode.mail.application.dto.MailInfoDTO;
import com.cleancoders.hackacode.mail.application.port.out.MailServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

@PersistenceAdapter //todo new adapter
public class MailServiceAdapter implements MailServicePort {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public String send(MailInfoDTO mailDTO) {
        return null;
    }
}
