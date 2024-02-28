package com.cleancoders.hackacode.sale.adapter.in.web;

import com.cleancoders.hackacode.sale.application.dto.NewSaleDTO;
import com.cleancoders.hackacode.sale.application.port.in.SalePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/sale")
public class SaleController {

    @Autowired
    private SalePersistence salePersistence;
    @PostMapping
    public ResponseEntity<?> newSale(@RequestBody NewSaleDTO body) {
        return ResponseEntity.ok(this.salePersistence.createSale(body));
    }

    /*
    TODO
        POST SALE
        GET SALES PAGE
        EDIT SALES
        DELETE SALE

        RECIBE
     */

}
