package com.joelrondinelpacheco.hackacode.person.adapter.out.persistence;

import com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.entity.UserCredentialsEntity;
import com.joelrondinelpacheco.hackacode.security.domain.UserCredentials;
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
    @Column(nullable = false, unique = true)
    private String email;
    private String address;
    private Integer dni;
    @Temporal(TemporalType.DATE)
    private Date birthday;
    private Integer phoneNumber;
    @OneToOne(mappedBy = "personEntity")
    private UserCredentialsEntity userCredentialsEntity;

}
