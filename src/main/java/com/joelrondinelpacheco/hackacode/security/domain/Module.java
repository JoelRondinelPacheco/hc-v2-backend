package com.joelrondinelpacheco.hackacode.security.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Module {
    private Long id;
    private String name;
    private String basePath;
}
