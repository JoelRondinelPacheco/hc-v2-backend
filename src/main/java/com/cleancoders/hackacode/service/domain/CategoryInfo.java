package com.cleancoders.hackacode.service.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class CategoryInfo extends Category {
    private List<ServiceBase> serviceBases;
}
