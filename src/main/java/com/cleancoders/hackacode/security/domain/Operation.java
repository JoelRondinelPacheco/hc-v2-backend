package com.cleancoders.hackacode.security.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Operation {
    private Long id;
    private String name;
    private String path;
    private String httpMethod;
    private boolean permitAll;
    private Module module;
}
