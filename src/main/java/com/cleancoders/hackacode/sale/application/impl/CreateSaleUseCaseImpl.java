package com.cleancoders.hackacode.sale.application.impl;

import com.cleancoders.hackacode.client.application.port.in.ClientSelector;
import com.cleancoders.hackacode.client.domain.Client;
import com.cleancoders.hackacode.common.UseCase;
import com.cleancoders.hackacode.user.application.port.in.UserSelector;
import com.cleancoders.hackacode.user.domain.User;
import com.cleancoders.hackacode.sale.application.CreateSaleUseCase;
import com.cleancoders.hackacode.sale.application.dto.NewSaleDTO;
import com.cleancoders.hackacode.sale.application.port.out.SalePersistencePort;
import com.cleancoders.hackacode.sale.domain.Sale;
import com.cleancoders.hackacode.saleitem.application.usecases.SaleItemService;
import com.cleancoders.hackacode.saleitem.domain.SaleItem;
import com.cleancoders.hackacode.service.application.port.in.ServiceSelector;
import com.cleancoders.hackacode.service.domain.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@UseCase
public class CreateSaleUseCaseImpl implements CreateSaleUseCase {

    @Autowired
    private SaleItemService saleItemService;
    @Autowired
    private SalePersistencePort saleRepository;


    //CLIENT
    @Autowired
    private ClientSelector clientSelector;

    //EMPLOYEE
    @Autowired
    private UserSelector userSelector;

    //SERVICES
    private ServiceSelector serviceSelector;

    public String createSale(NewSaleDTO saleInfo) {

        Client client = this.clientSelector.byId(saleInfo.getClientId());
        User user = this.userSelector.byId(saleInfo.getEmployeeId());

        List<Service> services = this.serviceSelector.listById(saleInfo.getServicesId());

        SaleItem saleItem = this.saleItemService.createSaleItem(services);

        Sale sale = new Sale.Builder()
                .employee(user)
                .client(client)
                .saleItem(saleItem)
                .build();

        this.saleRepository.save(sale);
        return "Todo sale ok";
    }

}
