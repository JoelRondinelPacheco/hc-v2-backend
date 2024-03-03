package com.cleancoders.hackacode.sale.adapter.out.persistence.mapper;

import com.cleancoders.hackacode.client.adapter.out.persistence.ClientEntity;
import com.cleancoders.hackacode.client.domain.Client;
import com.cleancoders.hackacode.common.PersistenceAdapter;
import com.cleancoders.hackacode.common.adapter.Mapper;
import com.cleancoders.hackacode.paymentmethod.adapter.out.persistence.PaymentMethodEntity;
import com.cleancoders.hackacode.paymentmethod.domain.PaymentMethod;
import com.cleancoders.hackacode.sale.adapter.out.persistence.SaleEntity;
import com.cleancoders.hackacode.sale.domain.SaleData;
import com.cleancoders.hackacode.sale.domain.SaleDataReference;
import com.cleancoders.hackacode.service.adapter.out.persistence.mapper.ServiceMapper;
import com.cleancoders.hackacode.service.domain.ServiceData;
import com.cleancoders.hackacode.user.adapter.out.persistence.mapper.UserMapper;
import com.cleancoders.hackacode.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

@PersistenceAdapter
public class SaleMapperImpl implements SaleMapper {

    @Autowired
    @Qualifier("paymentMethodMapper")
    private Mapper<PaymentMethod, PaymentMethodEntity> paymentMethodMapper;
    @Autowired
    @Qualifier("clientMapper")
    private Mapper<Client, ClientEntity> clientMapper;
    @Autowired
    private ServiceMapper serviceMapper;
    @Autowired
    private UserMapper userMapper;


    @Override
    public SaleData entityToDomain(SaleEntity entity) {

        Client client = this.clientMapper.entityToDomain(entity.getClient());
        User employee = this.userMapper.entityToDomain(entity.getEmployee());
        PaymentMethod paymentMethod = this.paymentMethodMapper.entityToDomain(entity.getPaymentMethod());

        List<ServiceData> services = this.serviceMapper.entityToDomainList(entity.getServices());

        return SaleData.builder()
                .id(entity.getId())
                .date(entity.getCreatedAt())
                .price(entity.getPrice())
                .type(entity.getType())
                .client(client)
                .user(employee)
                .paymentMethod(paymentMethod)
                .services(services)
                .build();
    }

    @Override
    public SaleEntity domainToEntity(SaleData domain) {
        return SaleEntity.builder()
                .type(domain.getType())
                .price(domain.getPrice())
                .build();
    }

    @Override
    public SaleEntity domainRefToEntity(SaleDataReference sale) {
        return null;
    }
}
