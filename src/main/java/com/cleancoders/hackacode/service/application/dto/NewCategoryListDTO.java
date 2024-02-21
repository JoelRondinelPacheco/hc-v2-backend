package com.cleancoders.hackacode.service.application.dto;

import com.cleancoders.hackacode.service.domain.Service;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
public class NewCategoryListDTO extends CategoryDTOBase {
    List<String> categoryNames;


}
