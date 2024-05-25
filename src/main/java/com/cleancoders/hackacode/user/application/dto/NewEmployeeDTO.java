package com.cleancoders.hackacode.user.application.dto;

import com.cleancoders.hackacode.person.application.dto.NewPersonDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NewEmployeeDTO extends NewPersonDTO {
    private BigDecimal salary;
}
