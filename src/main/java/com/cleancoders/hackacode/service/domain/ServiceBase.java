package com.cleancoders.hackacode.service.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class ServiceBase extends Service {
    private String code;
    private String name;
    private String description;
    private Date createdAt;
    private Date updatedAt;

}
