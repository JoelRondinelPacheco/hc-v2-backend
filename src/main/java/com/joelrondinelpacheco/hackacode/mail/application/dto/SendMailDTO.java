package com.joelrondinelpacheco.hackacode.mail.application.dto;

import com.joelrondinelpacheco.hackacode.mail.domain.MailType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SendMailDTO {
    private String token;
    private MailType mailType;
}
