package com.joelrondinelpacheco.hackacode.service.application.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class NewCategoryDTOb extends CategoryDTOBase {
    private String name;
}
