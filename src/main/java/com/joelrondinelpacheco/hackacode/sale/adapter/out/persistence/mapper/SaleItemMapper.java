package com.joelrondinelpacheco.hackacode.sale.adapter.out.persistence.mapper;


import com.joelrondinelpacheco.hackacode.common.adapter.Mapper;
import com.joelrondinelpacheco.hackacode.sale.adapter.out.persistence.SaleItemEntity;
import com.joelrondinelpacheco.hackacode.sale.domain.SaleItemData;
import com.joelrondinelpacheco.hackacode.sale.domain.SaleItemReference;

import java.util.List;

public interface SaleItemMapper extends Mapper<SaleItemData, SaleItemEntity> {

    SaleItemEntity domainToEntityRef(SaleItemReference saleItemReference);
    List<SaleItemEntity> domainToEntityRefList(List<SaleItemReference> saleItemReference);
}
