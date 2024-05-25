package com.cleancoders.hackacode.sale.adapter.out.persistence.mapper;

import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.sale.adapter.out.persistence.SaleEntity;
import com.cleancoders.hackacode.sale.domain.SaleData;
import com.cleancoders.hackacode.sale.domain.SaleReference;

public interface SaleMapper extends Mapper<SaleData, SaleEntity> {
    SaleEntity domainRefToEntity(SaleReference sale);
}
