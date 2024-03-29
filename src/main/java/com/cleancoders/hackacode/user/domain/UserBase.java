package com.cleancoders.hackacode.user.domain;

import com.cleancoders.hackacode.person.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class UserBase {
    private Long id;
    private Person person;
    private BigDecimal salary;
}
