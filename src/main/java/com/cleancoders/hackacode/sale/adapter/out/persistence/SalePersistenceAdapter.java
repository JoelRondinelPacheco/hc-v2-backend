package com.cleancoders.hackacode.sale.adapter.out.persistence;

import com.cleancoders.hackacode.client.adapter.out.persistence.ClientSelectorAdapter;
import com.cleancoders.hackacode.common.PersistenceAdapter;
import com.cleancoders.hackacode.paymentmethod.adapter.out.persistence.PaymentMethodSelectorMySQLPersistenceAdapter;
import com.cleancoders.hackacode.sale.adapter.out.persistence.mapper.SaleMapper;
import com.cleancoders.hackacode.sale.application.port.out.SalePersistencePort;
import com.cleancoders.hackacode.sale.domain.SaleData;
import com.cleancoders.hackacode.sale.domain.SaleDataReference;
import com.cleancoders.hackacode.service.adapter.out.persistence.ServiceSelectorPersistenceAdapter;
import com.cleancoders.hackacode.service.adapter.out.persistence.entity.ServiceEntity;
import com.cleancoders.hackacode.service.domain.Service;
import com.cleancoders.hackacode.user.adapter.out.persistence.UserSelectorAdapter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@PersistenceAdapter
public class SalePersistenceAdapter implements SalePersistencePort {

    @Autowired
    private SaleMySQLRepository saleRepository;
    @Autowired
    private ServiceSelectorPersistenceAdapter serviceMySQLRepository;
    @Autowired
    private SaleMapper mapper;


    @Autowired
    private ClientSelectorAdapter clientSelectorAdapter;
    @Autowired
    private UserSelectorAdapter userSelectorAdapter;
    @Autowired
    private PaymentMethodSelectorMySQLPersistenceAdapter paymentMethodSelector;

    @Override
    public SaleData newSale(SaleDataReference saleData) {
        List<ServiceEntity> serviceEntities = new ArrayList<>();
        for (Service service : saleData.getServices()) {
            serviceEntities.add(this.serviceMySQLRepository.entityById(service.getId()));
        }

        SaleEntity saleEntity = this.mapper.domainRefToEntity(saleData);
        saleEntity.setServices(serviceEntities);
        saleEntity.setClient(this.clientSelectorAdapter.entityById(saleData.getClient()));
        saleEntity.setEmployee(this.userSelectorAdapter.entityById(saleData.getEmployee()));
        saleEntity.setPaymentMethod(this.paymentMethodSelector.entityById(saleData.getPaymentMethod()));

        SaleEntity saleSaved = this.saleRepository.save(saleEntity);
        return this.mapper.entityToDomain(saleSaved);
    }
}
