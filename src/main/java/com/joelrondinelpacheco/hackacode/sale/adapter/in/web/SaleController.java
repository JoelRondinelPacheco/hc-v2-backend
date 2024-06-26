package com.joelrondinelpacheco.hackacode.sale.adapter.in.web;

import com.joelrondinelpacheco.hackacode.sale.application.dto.NewSaleDTO;
import com.joelrondinelpacheco.hackacode.sale.application.port.in.SalePersistence;
import com.joelrondinelpacheco.hackacode.sale.application.port.in.SaleSelector;
import com.joelrondinelpacheco.hackacode.sale.domain.SaleData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/sale")
public class SaleController {


    private final SalePersistence salePersistence;
    private final  SaleSelector saleSelector;

    public SaleController(SalePersistence salePersistence, SaleSelector saleSelector) {
        this.salePersistence = salePersistence;
        this.saleSelector = saleSelector;
    }

    @PostMapping
    public ResponseEntity<SaleData> newSale(@RequestBody NewSaleDTO body) {
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
