package com.cleancoders.hackacode.sale.adapter.out.persistence.mapper;


import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.sale.adapter.out.persistence.SaleItemEntity;
import com.cleancoders.hackacode.sale.domain.SaleItemData;
import com.cleancoders.hackacode.sale.domain.SaleItemReference;

import java.util.List;

public interface SaleItemMapper extends Mapper<SaleItemData, SaleItemEntity> {

    SaleItemEntity domainToEntityRef(SaleItemReference saleItemReference);
    List<SaleItemEntity> domainToEntityRefList(List<SaleItemReference> saleItemReference);
}
