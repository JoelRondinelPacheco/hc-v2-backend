package com.cleancoders.hackacode.sale.application.usecases.impl;

import com.cleancoders.hackacode.client.application.port.in.ClientSelector;
import com.cleancoders.hackacode.client.application.port.in.ClientUtils;
import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.paymentmethod.application.usecases.PaymentMethodUtils;
import com.cleancoders.hackacode.sale.adapter.out.persistence.mapper.SaleItemMapper;
import com.cleancoders.hackacode.sale.application.dto.SaleItemDTO;
import com.cleancoders.hackacode.sale.application.port.in.SalePersistence;
import com.cleancoders.hackacode.sale.domain.*;
import com.cleancoders.hackacode.user.application.port.in.UserSelector;
import com.cleancoders.hackacode.user.application.usecases.EmployeeUtils;
import com.cleancoders.hackacode.sale.application.dto.NewSaleDTO;
import com.cleancoders.hackacode.sale.application.port.out.SalePersistencePort;
import com.cleancoders.hackacode.service.application.port.in.ServiceSelector;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@UseCase
public class SalePersistenceImpl implements SalePersistence {

    @Autowired
    private SalePersistencePort saleRepository;

    @Autowired
    private SaleItemMapper saleItemMapper;

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

        List<SaleItemReference> saleItems = this.serviceSelector.saleItemsInfo(saleInfo.getSaleItems());
        /*
        recibe solo ids de los servicios
        que necesito para:
            hacer query
            guardar nuevo
                verifico todos los services ids, y creo los saleItems con los ids que existen
                envio a guardar la sale
         */

        //todo add discount in sale
        SaleDataReference sale = SaleDataReference.withSaleItemReferences(saleItems);
        sale.setClient(saleInfo.getClientId());
        sale.setEmployee(saleInfo.getEmployeeId());
        sale.setPaymentMethod(saleInfo.getPaymentMethodId());

        return this.saleRepository.newSale(sale);
    }

    private SaleType setSaleType(int size) {
        return size > 1 ? SaleType.PACKAGE : SaleType.SINGLE_SALE;
    }

}
