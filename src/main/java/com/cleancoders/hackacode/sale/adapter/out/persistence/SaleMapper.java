package com.cleancoders.hackacode.sale.adapter.out.persistence;

import com.cleancoders.hackacode.client.adapter.out.persistence.ClientEntity;
import com.cleancoders.hackacode.client.domain.Client;
import com.cleancoders.hackacode.common.PersistenceAdapter;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.paymentmethod.adapter.out.persistence.PaymentMethodEntity;
import com.cleancoders.hackacode.paymentmethod.domain.PaymentMethod;
import com.cleancoders.hackacode.sale.domain.Sale;
import com.cleancoders.hackacode.sale.domain.SaleData;
import com.cleancoders.hackacode.saleitem.application.usecases.SaleItemService;
import com.cleancoders.hackacode.saleitem.domain.SaleItem;
import com.cleancoders.hackacode.service.adapter.out.persistence.mapper.ServiceMapper;
import com.cleancoders.hackacode.service.domain.Service;
import com.cleancoders.hackacode.user.adapter.out.persistence.mapper.UserMapper;
import com.cleancoders.hackacode.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

@PersistenceAdapter
@Qualifier("saleMapper")
public class SaleMapper implements Mapper<Sale, SaleEntity> {

    @Autowired
    @Qualifier("paymentMethodMapper")
    private Mapper<PaymentMethod, PaymentMethodEntity> paymentMethodMapper;
    @Autowired
    @Qualifier("clientMapper")
    private Mapper<Client, ClientEntity> clientMapper;
    @Autowired
    @Qualifier("serviceMapper")
    private ServiceMapper serviceMapper;
    @Autowired
    private UserMapper userMapper;

    //TODO VER SI SE PUEDE LLAMAR DESDE ESTA CAPA
    @Autowired
    private SaleItemService saleItemService;

    @Override
    public Sale entityToDomain(SaleEntity saleEntity) {

        Client client = this.clientMapper.entityToDomain(saleEntity.getClient());
        User employee = this.userMapper.entityToDomain(saleEntity.getEmployee());
        PaymentMethod paymentMethod = this.paymentMethodMapper.entityToDomain(saleEntity.getPaymentMethod());

        List<Service> services = this.serviceMapper.entityToDomainList(saleEntity.getServices());
        SaleItem saleItem = this.saleItemService.createSaleItem(services);


        return SaleData.builder()
                .id(saleEntity.getId())
                .date(saleEntity.getCreatedAt())
                .price(saleEntity.getPrice())
                .type(saleEntity.getType())
                .client(client)
                .user(employee)
                .paymentMethod(paymentMethod)
                .saleItem(saleItem)
                .build();
    }

    @Override
    public SaleEntity domainToEntity(Sale sale) {
        return null;
    }
}
