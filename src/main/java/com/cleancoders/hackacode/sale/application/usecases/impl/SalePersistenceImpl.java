package com.cleancoders.hackacode.sale.application.usecases.impl;

import com.cleancoders.hackacode.client.application.port.in.ClientSelector;
import com.cleancoders.hackacode.client.application.port.in.ClientUtils;
import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.paymentmethod.application.usecases.PaymentMethodUtils;
import com.cleancoders.hackacode.sale.application.port.in.SalePersistence;
import com.cleancoders.hackacode.sale.domain.*;
import com.cleancoders.hackacode.service.application.dto.ServicePriceInfo;
import com.cleancoders.hackacode.service.domain.Service;
import com.cleancoders.hackacode.user.application.port.in.UserSelector;
import com.cleancoders.hackacode.user.application.usecases.EmployeeUtils;
import com.cleancoders.hackacode.sale.application.dto.NewSaleDTO;
import com.cleancoders.hackacode.sale.application.port.out.SalePersistencePort;
import com.cleancoders.hackacode.service.application.port.in.ServiceSelector;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@UseCase
public class SalePersistenceImpl implements SalePersistence {

    @Autowired
    private SalePersistencePort saleRepository;


    //CLIENT
    @Autowired
    private ClientSelector clientSelector;
    @Autowired
    private ClientUtils clientUtils;

    //EMPLOYEE
    @Autowired
    private UserSelector userSelector;
    @Autowired
    private EmployeeUtils employeeUtils;

    //PAYMENT METHOD
    @Autowired
    private PaymentMethodUtils paymentMethodUtils;

    //SERVICES
    @Autowired
    private ServiceSelector serviceSelector;

    @Override
    public SaleData createSale(NewSaleDTO saleInfo) {


        this.paymentMethodUtils.assertExistsById(saleInfo.getPaymentMethodId());
        this.clientUtils.assertExistsById(saleInfo.getClientId());
        this.employeeUtils.assertExistsById(saleInfo.getEmployeeId());

        //llamar a los servicios en la otra capa, para no buscar toda la entidad con fechas etc
        List<ServicePriceInfo> servicesPrice = this.serviceSelector.servicePriceList(saleInfo.getServicesId());

        //todo create method
        List<Service> services = new ArrayList<>();
        for (ServicePriceInfo s : servicesPrice) {
            services.add(new Service(s.getId(), s.getPrice()));
        }

        SaleDataReference saleB = SaleDataReference.withServices(services);
        saleB.setClient(saleInfo.getClientId());
        saleB.setEmployee(saleInfo.getEmployeeId());
        saleB.setPaymentMethod(saleInfo.getPaymentMethodId());

        return this.saleRepository.newSale(saleB);
    }

    private SaleType setSaleType(int size) {
        return size > 1 ? SaleType.PACKAGE : SaleType.SINGLE_SALE;
    }

}
