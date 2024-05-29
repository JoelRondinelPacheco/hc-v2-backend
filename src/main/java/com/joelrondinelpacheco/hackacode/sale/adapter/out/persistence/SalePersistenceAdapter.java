package com.joelrondinelpacheco.hackacode.sale.adapter.out.persistence;

import com.joelrondinelpacheco.hackacode.client.adapter.out.persistence.ClientSelectorAdapter;
import com.joelrondinelpacheco.hackacode.common.PersistenceAdapter;
import com.joelrondinelpacheco.hackacode.paymentmethod.adapter.out.persistence.PaymentMethodSelectorMySQLPersistenceAdapter;
import com.joelrondinelpacheco.hackacode.paymentmethod.adapter.out.persistence.mapper.PaymentMethodMapper;
import com.joelrondinelpacheco.hackacode.sale.adapter.out.persistence.mapper.SaleItemMapper;
import com.joelrondinelpacheco.hackacode.sale.adapter.out.persistence.mapper.SaleMapper;
import com.joelrondinelpacheco.hackacode.sale.application.port.out.SalePersistencePort;
import com.joelrondinelpacheco.hackacode.sale.domain.SaleData;
import com.joelrondinelpacheco.hackacode.sale.domain.SaleReference;
import com.joelrondinelpacheco.hackacode.sale.domain.SaleItemReference;
import com.joelrondinelpacheco.hackacode.service.adapter.out.persistence.ServiceSelectorPersistenceAdapter;
import com.joelrondinelpacheco.hackacode.service.adapter.out.persistence.entity.ServiceEntity;
import com.joelrondinelpacheco.hackacode.user.adapter.out.persistence.UserSelectorAdapter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@PersistenceAdapter
public class SalePersistenceAdapter implements SalePersistencePort {

    @Autowired
    private SaleMySQLRepository saleRepository;
    @Autowired
    private SaleItemMySQLRepository saleItemRepository;


    @Autowired
    private ServiceSelectorPersistenceAdapter serviceMySQLRepository;
    @Autowired
    private SaleMapper saleMapper;
    @Autowired
    private SaleItemMapper saleItemMapper;
    @Autowired
    private PaymentMethodMapper paymentMethodMapper;

    @Autowired
    private ClientSelectorAdapter clientSelectorAdapter;
    @Autowired
    private UserSelectorAdapter userSelectorAdapter;
    @Autowired
    private PaymentMethodSelectorMySQLPersistenceAdapter paymentMethodSelector;

    @Override
    public SaleData newSale(SaleReference saleData) {
        List<SaleItemEntity> saleItemEntities = new ArrayList<>();
        for (SaleItemReference saleItem : saleData.getSaleItemReferences()) {
            //TODO TRY CATCH
            ServiceEntity service = this.serviceMySQLRepository.entityById(saleItem.getService().getId());

            SaleItemEntity saleItemEntity = this.saleItemMapper.domainToEntityRef(saleItem);
            saleItemEntity.setService(service);

            saleItemEntities.add(saleItemEntity);
        }

        SaleEntity saleEntity = this.saleMapper.domainRefToEntity(saleData);
        saleEntity.setClient(this.clientSelectorAdapter.entityById(saleData.getClient()));
        saleEntity.setEmployee(this.userSelectorAdapter.entityById(saleData.getEmployee()));
        saleEntity.setPaymentMethod(this.paymentMethodMapper.domainToEntityWithId(saleData.getPaymentMethod()));

        SaleEntity saleSaved = this.saleRepository.save(saleEntity);
        for (SaleItemEntity s : saleItemEntities) {
            s.setSale(saleSaved);
        }

        saleSaved.setSaleItem(this.saleItemRepository.saveAll(saleItemEntities));

        return this.saleMapper.entityToDomain(saleSaved);
    }
}
