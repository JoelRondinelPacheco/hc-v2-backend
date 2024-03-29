package com.cleancoders.hackacode.security.application.dto.operation;

import com.cleancoders.hackacode.security.application.dto.module.ModuleInfoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class OperationInfoDTO extends OperationDTO {
    private Long id;
    private ModuleInfoDTO module;
}
