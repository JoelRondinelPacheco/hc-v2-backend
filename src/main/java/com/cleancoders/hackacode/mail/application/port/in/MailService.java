package com.cleancoders.hackacode.mail.application.port.in;

import com.cleancoders.hackacode.mail.application.dto.Mail;

public interface MailService {

    String registerEmail(Mail mailDTO);
    String forgotPassword(Mail mailDTO);
    String send(Mail mailDTO);
}
