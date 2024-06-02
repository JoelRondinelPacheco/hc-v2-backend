package com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.entity;

import com.joelrondinelpacheco.hackacode.person.adapter.out.persistence.PersonEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class UserCredentialsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_email", referencedColumnName = "email")
    private PersonEntity personEntity;
    private String password;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    private String token; //TODO string o otro tipo


    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;


}