package com.joelrondinelpacheco.hackacode.common.adapter;

public interface Mapper <DOMAIN, ENTITY>{
    DOMAIN entityToDomain(ENTITY entity);
    ENTITY domainToEntity(DOMAIN domain);
}
