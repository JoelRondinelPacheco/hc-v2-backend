package com.cleancoders.hackacode.employee.adapter.out.persistence;

import com.cleancoders.hackacode.user.adapter.out.persistence.UserEntity;
import jakarta.persistence.*;

@Entity(name = "employee")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;


}
