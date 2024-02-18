package com.cleancoders.hackacode.employee.domain;

import com.cleancoders.hackacode.sale.domain.Sale;
import com.cleancoders.hackacode.user.domain.User;

import java.util.List;

public class Employee {
    private Long id;
    private User user;
    private List<Sale> sales;
}
