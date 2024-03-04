package com.cleancoders.hackacode.sale.application.port.out;

import com.cleancoders.hackacode.sale.domain.SaleData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SaleSelectorPort {

    Page<SaleData> getPage(Pageable pageable);
}
