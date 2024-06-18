package com.joelrondinelpacheco.hackacode.service.application.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class NewCategoryDTOb extends CategoryDTOBase {
    private String name;
}
