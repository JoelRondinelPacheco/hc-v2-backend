package com.cleancoders.hackacode.security.application.dto.module;

import com.cleancoders.hackacode.security.application.dto.module.ModuleDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class ModuleInfoDTO extends ModuleDTO {
    private String id;
}
