package com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.entity;

import com.joelrondinelpacheco.hackacode.person.adapter.out.persistence.PersonEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "user_credential")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserCredentialsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_email", referencedColumnName = "email")
    private PersonEntity personEntity;
    @Column(nullable = false)
    private String password;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    private String emailToken; //TODO string o otro tipo


    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;


}
