package com.cleancoders.hackacode.sale.application.port.in;

import com.cleancoders.hackacode.sale.domain.SaleData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SaleSelector {
    Page<SaleData> getPage(Pageable pageable);
}
