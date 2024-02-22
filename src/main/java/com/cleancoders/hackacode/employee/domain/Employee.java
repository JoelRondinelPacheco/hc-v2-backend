package com.cleancoders.hackacode.employee.domain;

import com.cleancoders.hackacode.sale.domain.Sale;
import com.cleancoders.hackacode.user.domain.User;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Employee {
    private Long id;
    private User user;
    private Long userId;
    private BigDecimal salary;
    private List<Sale> sales;

}
