package com.joelrondinelpacheco.hackacode.service.application.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class NewCategoryListDTO extends CategoryDTOBase {
    List<String> categoryNames;


}
