package com.joelrondinelpacheco.hackacode.service.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class ServiceReference extends ServiceBase {
    private Long category;
}
