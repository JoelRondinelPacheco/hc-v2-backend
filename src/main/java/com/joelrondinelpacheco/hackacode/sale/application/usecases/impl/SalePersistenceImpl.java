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

import java.util.List;

@UseCase
public class SalePersistenceImpl implements SalePersistence {

    private final SalePersistencePort saleRepository;
    private final SaleItemMapper saleItemMapper;
    private final ClientSelector clientSelector;
    private final ClientUtils clientUtils;
    private final EmployeeSelector employeeSelector;
    private final EmployeeUtils employeeUtils;
    private final PaymentMethodUtils paymentMethodUtils;
    private final ServiceSelector serviceSelector;
    private final PaymentMethodSelector paymentMethodSelector;

    public SalePersistenceImpl(SalePersistencePort saleRepository, SaleItemMapper saleItemMapper, ClientSelector clientSelector, ClientUtils clientUtils, EmployeeSelector employeeSelector, EmployeeUtils employeeUtils, PaymentMethodUtils paymentMethodUtils, ServiceSelector serviceSelector, PaymentMethodSelector paymentMethodSelector) {
        this.saleRepository = saleRepository;
        this.saleItemMapper = saleItemMapper;
        this.clientSelector = clientSelector;
        this.clientUtils = clientUtils;
        this.employeeSelector = employeeSelector;
        this.employeeUtils = employeeUtils;
        this.paymentMethodUtils = paymentMethodUtils;
        this.serviceSelector = serviceSelector;
        this.paymentMethodSelector = paymentMethodSelector;
    }

    @Override
    public SaleData createSale(NewSaleDTO saleInfo) {

        // TODO Eliminar y solo manejar expeciones?
        this.paymentMethodUtils.assertExistsById(saleInfo.getPaymentMethodId());
        this.clientUtils.assertExistsById(saleInfo.getClientId());
        //this.employeeUtils.assertExistsById(saleInfo.getEmployeeEmail());

        List<SaleItemReference> saleItems = this.serviceSelector.saleItemsInfo(saleInfo.getSaleItems());

        PaymentMethod paymentMethod = this.paymentMethodSelector.byId(saleInfo.getPaymentMethodId());

        SaleReference sale = SaleReference.withSaleItemReferencesAndPaymentMethod(saleItems, paymentMethod);
        sale.setClient(saleInfo.getClientId());
        sale.setEmployeeEmail(saleInfo.getEmployeeEmail());
        sale.setInterest(paymentMethod.getInterest());

        return this.saleRepository.newSale(sale);
    }

    private SaleType setSaleType(int size) {
        return size > 1 ? SaleType.PACKAGE : SaleType.SINGLE_SALE;
    }

}
