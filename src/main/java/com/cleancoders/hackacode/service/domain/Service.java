package com.cleancoders.hackacode.service.domain;

import com.cleancoders.hackacode.saleitem.domain.SaleItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class Service implements SaleItem {
    private Long id;
    private BigDecimal price;

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public List<Service> getServices() {
        List<Service> s = new ArrayList<>();
        s.add(this);
        return s;
    }


    @Override
    public int getItemsSize() {
        return 0;
    }

}
