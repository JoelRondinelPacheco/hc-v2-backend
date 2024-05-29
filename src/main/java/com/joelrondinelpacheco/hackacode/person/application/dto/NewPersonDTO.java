package com.joelrondinelpacheco.hackacode.person.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class NewPersonDTO extends PersonBaseDTO {
    private Long roleId;
}
