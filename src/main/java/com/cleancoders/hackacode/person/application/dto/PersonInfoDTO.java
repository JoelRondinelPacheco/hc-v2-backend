package com.cleancoders.hackacode.person.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class PersonInfoDTO extends PersonBaseDTO {
    private Long id;
}
