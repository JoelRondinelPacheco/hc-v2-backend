package com.cleancoders.hackacode.service.application.dto;

import com.cleancoders.hackacode.service.domain.Service;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class CategoryDTOBase {
    private Long serviceId;
}
