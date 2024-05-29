package com.joelrondinelpacheco.hackacode.user.application.dto;

import com.joelrondinelpacheco.hackacode.person.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserInfoDTO {
    private Long id;
    private Person person;
    private BigDecimal salary;
}
