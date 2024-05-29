package com.joelrondinelpacheco.hackacode.common.adapter;

public interface MapperDTO <DTO, ENTITY> {
    ENTITY dtoToEntity(DTO dto);
}
