package com.joelrondinelpacheco.hackacode.employee.adapter.out.persistence;

import com.joelrondinelpacheco.hackacode.person.adapter.out.persistence.PersonEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity(name = "user_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private PersonEntity person;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal salary;
    private String password;

}
