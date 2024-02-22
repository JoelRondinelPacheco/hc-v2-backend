package com.cleancoders.hackacode.user.application.dto;

import com.cleancoders.hackacode.person.application.dto.NewPersonDTO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class NewEmployeeDTO extends NewPersonDTO {
    private BigDecimal salary;
}
