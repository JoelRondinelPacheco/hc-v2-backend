package com.cleancoders.hackacode.person.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class NewPersonDTO extends PersonBaseDTO {
    private Long roleId;
}
