package com.cleancoders.hackacode.client.domain;

import com.cleancoders.hackacode.person.domain.Person;

public class Client {
    private Long id;
    private Person person;

    public Client() {
    }

    private Client(Person person) {
        this.person = person;
    }

    public static Client withUser(Person person) {
        return new Client(person);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Person getUser() {
        return person;
    }

    public void setUser(Person person) {
        this.person = person;
    }
}
