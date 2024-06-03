package com.joelrondinelpacheco.hackacode.sale.application.usecases.impl;

import com.joelrondinelpacheco.hackacode.client.application.port.in.ClientSelector;
import com.joelrondinelpacheco.hackacode.client.application.port.in.ClientUtils;
import com.joelrondinelpacheco.hackacode.common.UseCase;
import com.joelrondinelpacheco.hackacode.paymentmethod.application.port.in.PaymentMethodSelector;
import com.joelrondinelpacheco.hackacode.paymentmethod.application.usecases.PaymentMethodUtils;
import com.joelrondinelpacheco.hackacode.paymentmethod.domain.PaymentMethod;
import com.joelrondinelpacheco.hackacode.sale.adapter.out.persistence.mapper.SaleItemMapper;
import com.joelrondinelpacheco.hackacode.sale.application.port.in.SalePersistence;
import com.joelrondinelpacheco.hackacode.sale.domain.SaleData;
import com.joelrondinelpacheco.hackacode.sale.domain.SaleItemReference;
import com.joelrondinelpacheco.hackacode.sale.domain.SaleReference;
import com.joelrondinelpacheco.hackacode.employee.application.port.in.EmployeeSelector;
import com.joelrondinelpacheco.hackacode.employee.application.usecases.EmployeeUtils;
import com.joelrondinelpacheco.hackacode.sale.application.dto.NewSaleDTO;
import com.joelrondinelpacheco.hackacode.sale.application.port.out.SalePersistencePort;
import com.joelrondinelpacheco.hackacode.service.application.port.in.ServiceSelector;
import com.joelrondinelpacheco.hackacode.sale.domain.SaleType;
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
    private EmployeeSelector employeeSelector;
    @Autowired
    private EmployeeUtils employeeUtils;

    //PAYMENT METHOD
    @Autowired
    private PaymentMethodUtils paymentMethodUtils;

    //SERVICES
    @Autowired
    private ServiceSelector serviceSelector;

    @Autowired
    private PaymentMethodSelector paymentMethodSelector;

    @Override
    public SaleData createSale(NewSaleDTO saleInfo) {


        this.paymentMethodUtils.assertExistsById(saleInfo.getPaymentMethodId());
        this.clientUtils.assertExistsById(saleInfo.getClientId());
        this.employeeUtils.assertExistsById(saleInfo.getEmployeeId());

        List<SaleItemReference> saleItems = this.serviceSelector.saleItemsInfo(saleInfo.getSaleItems());

        PaymentMethod paymentMethod = this.paymentMethodSelector.byId(saleInfo.getPaymentMethodId());

        SaleReference sale = SaleReference.withSaleItemReferencesAndPaymentMethod(saleItems, paymentMethod);
        sale.setClient(saleInfo.getClientId());
        sale.setEmployee(saleInfo.getEmployeeId());
        sale.setInterest(paymentMethod.getInterest());

        return this.saleRepository.newSale(sale);
    }

    private SaleType setSaleType(int size) {
        return size > 1 ? SaleType.PACKAGE : SaleType.SINGLE_SALE;
    }

}
