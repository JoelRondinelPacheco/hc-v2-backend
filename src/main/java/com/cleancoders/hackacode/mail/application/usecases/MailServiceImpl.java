package com.cleancoders.hackacode.mail.application.usecases;

import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.mail.application.dto.Mail;
import com.cleancoders.hackacode.mail.application.port.in.MailService;

@UseCase
public class MailServiceImpl implements MailService {
    @Override
    public String registerEmail(Mail mailDTO) {
        return null;
    }

    @Override
    public String forgotPassword(Mail mailDTO) {
        return null;
    }

    @Override
    public String send(Mail mailDTO) {
        return null;
    }
}
