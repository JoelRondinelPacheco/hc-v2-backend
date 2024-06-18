package com.joelrondinelpacheco.hackacode.service.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class ServiceBase extends Service {
    private String name;
    private String description;
    private Date createdAt;
    private Date updatedAt;
}
