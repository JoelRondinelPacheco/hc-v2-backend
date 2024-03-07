package com.cleancoders.hackacode.person.adapter.out.persistence;

import com.cleancoders.hackacode.security.adapter.out.persistence.entity.RoleEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity(name = "person")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String address;
    private Integer dni;
    private Date birthday;
    private String nationality;
    private Integer phoneNumber;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;

}
