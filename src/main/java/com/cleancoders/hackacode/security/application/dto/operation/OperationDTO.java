package com.cleancoders.hackacode.security.application.dto.operation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class OperationDTO {
    private String name;
    private String path;
    private String httpMethod;
    private boolean permitAll;
    private Long moduleId;
}
