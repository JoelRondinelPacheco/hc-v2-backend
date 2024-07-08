package com.joelrondinelpacheco.hackacode.employee.application.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class UpdateEmployeeDTO extends NewEmployeeDTO{
    private Long id;
    private Long personId;
}
