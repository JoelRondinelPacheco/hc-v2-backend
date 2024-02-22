package com.cleancoders.hackacode.employee.application.dto;

import com.cleancoders.hackacode.user.application.dto.NewUserDTO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class NewEmployeeDTO extends NewUserDTO {
    private BigDecimal salary;
}
