package com.joelrondinelpacheco.hackacode.security.application.dto.module;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class ModuleDTO {
    private String name;
    private String basePath;
}
