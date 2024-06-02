package com.joelrondinelpacheco.hackacode.employee.application.dto;

import com.joelrondinelpacheco.hackacode.person.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EmployeeInfoDTO {
    private Long id;
    private Person person;
    private BigDecimal salary;
}
