package com.joelrondinelpacheco.hackacode.client.adapter.out.persistence;

import com.joelrondinelpacheco.hackacode.person.adapter.out.persistence.PersonEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "client")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "person_id")
    private PersonEntity person;

}
