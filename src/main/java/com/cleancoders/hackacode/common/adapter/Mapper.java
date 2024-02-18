package com.cleancoders.hackacode.common.adapter;

public interface Mapper <D, E>{
    D entityToDomain(E e);
    E domainToEntity(D d);
}
