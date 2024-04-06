package com.cleancoders.hackacode.sale.adapter.in.web;

import com.cleancoders.hackacode.sale.application.dto.NewSaleDTO;
import com.cleancoders.hackacode.sale.application.port.in.SalePersistence;
import com.cleancoders.hackacode.sale.application.port.in.SaleSelector;
import com.cleancoders.hackacode.sale.domain.SaleData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

@CrossOrigin
@RestController
@RequestMapping("/sale")
public class SaleController {

    @Autowired
    private SalePersistence salePersistence;
    @Autowired
    private SaleSelector saleSelector;

    @PostMapping
    public ResponseEntity<?> newSale(@RequestBody NewSaleDTO body) {
        return ResponseEntity.ok(this.salePersistence.createSale(body));
    }

    @GetMapping
    public ResponseEntity<Page<SaleData>> getSalePage(Pageable pageable) {
        return ResponseEntity.ok(this.saleSelector.getPage(pageable));
    }

    @GetMapping("/month")
    public ResponseEntity<Page<SaleData>> getSalesByMonth(@RequestParam LocalDate date, Pageable pageable) {
        Page<SaleData> saleData = this.saleSelector.getSalesByMonth(date, pageable);
        return ResponseEntity.ok(saleData);
    }

    @GetMapping("/day")
    public ResponseEntity<Page<SaleData>> getSalesByDay(@RequestParam LocalDate date, Pageable pageable) {
        Page<SaleData> saleData = this.saleSelector.getSalesByDay(date, pageable);
        return ResponseEntity.ok(saleData);
    }


}
