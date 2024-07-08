package com.joelrondinelpacheco.hackacode.employee.application.dto;

import com.joelrondinelpacheco.hackacode.person.application.dto.PersonBaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class NewEmployeeDTO extends PersonBaseDTO {
    private BigDecimal salary;
}
