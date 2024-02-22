package com.cleancoders.hackacode.user.domain;

import com.cleancoders.hackacode.person.domain.Person;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class User {
    private Long id;
    private Person person;
    private String password;
    private BigDecimal salary;
  //  private List<Sale> sales;

}
