package com.cleancoders.hackacode.mail.application.port.out;

import com.cleancoders.hackacode.mail.application.dto.MailInfoDTO;

public interface MailServicePort {
    String send(MailInfoDTO mailDTO);
}
