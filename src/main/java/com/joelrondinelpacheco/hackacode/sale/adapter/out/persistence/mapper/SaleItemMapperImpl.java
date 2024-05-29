package com.joelrondinelpacheco.hackacode.sale.adapter.out.persistence.mapper;

import com.joelrondinelpacheco.hackacode.common.PersistenceMapper;
import com.joelrondinelpacheco.hackacode.sale.adapter.out.persistence.SaleItemEntity;
import com.joelrondinelpacheco.hackacode.sale.domain.SaleItemData;
import com.joelrondinelpacheco.hackacode.sale.domain.SaleItemReference;
import com.joelrondinelpacheco.hackacode.service.adapter.out.persistence.mapper.ServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@PersistenceMapper
public class SaleItemMapperImpl implements SaleItemMapper{

    @Autowired
    private ServiceMapper serviceMapper;

    @Override
    public SaleItemData entityToDomain(SaleItemEntity saleItemEntity) {
        return SaleItemData.builder()
                .id(saleItemEntity.getId())
                .quantity(saleItemEntity.getQuantity())
                .from(saleItemEntity.getStartDate())
                .to(saleItemEntity.getEndDate())
                .service(this.serviceMapper.entityToDomain(saleItemEntity.getService()))
                .build();
    }

    @Override
    public SaleItemEntity domainToEntity(SaleItemData saleItemData) {
        return SaleItemEntity.builder()
                .quantity(saleItemData.getQuantity())
                .startDate(saleItemData.getFrom())
                .endDate(saleItemData.getTo())
                .build();
    }

    @Override
    public SaleItemEntity domainToEntityRef(SaleItemReference saleItem) {
        return SaleItemEntity.builder()
                .quantity(saleItem.getQuantity())
                .startDate(saleItem.getFrom())
                .endDate(saleItem.getTo())
                .build();
    }

    @Override
    public List<SaleItemEntity> domainToEntityRefList(List<SaleItemReference> saleItemReference) {
        List<SaleItemEntity> saleItemEntities = new ArrayList<>();

        for (SaleItemReference s : saleItemReference) {
            saleItemEntities.add(this.domainToEntityRef(s));
        }

        return saleItemEntities;
    }
}
