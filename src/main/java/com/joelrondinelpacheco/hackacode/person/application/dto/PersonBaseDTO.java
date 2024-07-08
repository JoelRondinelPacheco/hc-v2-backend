package com.joelrondinelpacheco.hackacode.person.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class PersonBaseDTO {
    private String name;
    private String lastname;
    @NotEmpty
    @NotNull
    private String email;
    private String address;
    private Integer dni;
    private Date birthday;
    private Integer phoneNumber;
}
