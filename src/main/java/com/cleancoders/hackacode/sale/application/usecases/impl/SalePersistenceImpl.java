package com.cleancoders.hackacode.sale.application.usecases.impl;

import com.cleancoders.hackacode.client.application.port.in.ClientSelector;
import com.cleancoders.hackacode.client.application.port.in.ClientUtils;
import com.cleancoders.hackacode.client.domain.Client;
import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.paymentmethod.application.usecases.PaymentMethodUtils;
import com.cleancoders.hackacode.sale.application.port.in.SalePersistence;
import com.cleancoders.hackacode.sale.domain.Sale;
import com.cleancoders.hackacode.sale.domain.SaleReference;
import com.cleancoders.hackacode.sale.domain.SaleType;
import com.cleancoders.hackacode.user.application.port.in.UserSelector;
import com.cleancoders.hackacode.user.application.usecases.EmployeeUtils;
import com.cleancoders.hackacode.sale.application.dto.NewSaleDTO;
import com.cleancoders.hackacode.sale.application.port.out.SalePersistencePort;
import com.cleancoders.hackacode.saleitem.application.usecases.SaleItemService;
import com.cleancoders.hackacode.saleitem.domain.SaleItem;
import com.cleancoders.hackacode.service.application.port.in.ServiceSelector;
import com.cleancoders.hackacode.service.domain.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@UseCase
public class SalePersistenceImpl implements SalePersistence {

    @Autowired
    private SaleItemService saleItemService;
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
    private ServiceSelector serviceSelector;

    @Override
    public Sale createSale(NewSaleDTO saleInfo) {


        this.paymentMethodUtils.assertExistsById(saleInfo.getPaymentMethodId());
        this.clientUtils.assertExistsById(saleInfo.getClientId());
        this.employeeUtils.assertExistsById(saleInfo.getEmployeeId());

        List<Service> services = this.serviceSelector.listById(saleInfo.getServicesId());

        //solo enviar los ids

        SaleItem saleItem = this.saleItemService.createSaleItem(services);

        Sale sale = SaleReference.builder()
                //ref
                .paymentMethod(saleInfo.getPaymentMethodId())
                .client(saleInfo.getClientId())
                .employee(saleInfo.getEmployeeId())
                //ref
                .saleItem(saleItem)
                .price(saleItem.getPrice())
                //todo refactor
                .type(setSaleType(saleItem.getItemsSize()))
                .build();

        return this.saleRepository.save(sale);
    }

    private SaleType setSaleType(int size) {
        return size > 1 ? SaleType.PACKAGE : SaleType.SINGLE_SALE;
    }

}
