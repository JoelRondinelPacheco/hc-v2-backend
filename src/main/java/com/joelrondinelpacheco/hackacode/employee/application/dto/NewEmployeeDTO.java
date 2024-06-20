package com.joelrondinelpacheco.hackacode.employee.application.dto;

import com.joelrondinelpacheco.hackacode.person.application.dto.NewPersonDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NewEmployeeDTO extends NewPersonDTO {
    private BigDecimal salary;
}
