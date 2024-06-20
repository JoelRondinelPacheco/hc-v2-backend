package com.joelrondinelpacheco.hackacode.security.application.dto.operation;

import com.joelrondinelpacheco.hackacode.security.application.dto.module.ModuleInfoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class OperationInfoDTO extends OperationDTO {
    private Long id;
    private ModuleInfoDTO module;
}
