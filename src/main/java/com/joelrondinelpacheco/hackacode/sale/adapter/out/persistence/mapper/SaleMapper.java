package com.joelrondinelpacheco.hackacode.sale.adapter.out.persistence.mapper;

import com.joelrondinelpacheco.hackacode.common.adapter.Mapper;
import com.joelrondinelpacheco.hackacode.sale.adapter.out.persistence.SaleEntity;
import com.joelrondinelpacheco.hackacode.sale.domain.SaleData;
import com.joelrondinelpacheco.hackacode.sale.domain.SaleReference;

public interface SaleMapper extends Mapper<SaleData, SaleEntity> {
    SaleEntity domainRefToEntity(SaleReference sale);
}
