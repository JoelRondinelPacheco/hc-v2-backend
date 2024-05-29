package com.joelrondinelpacheco.hackacode.security.application.dto.operation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class NewOperationDTO {
    private Long moduleId;
}
