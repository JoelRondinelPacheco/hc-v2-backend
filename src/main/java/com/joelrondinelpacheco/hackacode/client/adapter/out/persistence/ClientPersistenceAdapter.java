package com.joelrondinelpacheco.hackacode.client.adapter.out.persistence;

import com.joelrondinelpacheco.hackacode.client.application.port.out.ClientPersistencePort;
import com.joelrondinelpacheco.hackacode.client.domain.Client;
import com.joelrondinelpacheco.hackacode.common.PersistenceAdapter;
import com.joelrondinelpacheco.hackacode.common.adapter.Mapper;
import com.joelrondinelpacheco.hackacode.person.adapter.out.persistence.PersonEntity;
import com.joelrondinelpacheco.hackacode.person.adapter.out.persistence.PersonMySQLRepository;
import com.joelrondinelpacheco.hackacode.person.domain.Person;
import com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.entity.RoleEntity;
import com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.entity.UserCredentialsEntity;
import com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.mapper.UserCredentialsMapper;
import com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.repository.RoleMySQLRepository;
import com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.repository.UserCredentialsRepository;
import com.joelrondinelpacheco.hackacode.users.application.dto.UserStarterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

@PersistenceAdapter
public class ClientPersistenceAdapter implements ClientPersistencePort {


    private final ClientMySQLRepository clientMySQLRepository;
    private final PersonMySQLRepository personMySQLRepository;
    private final UserCredentialsRepository userCredentialsRepository;
    private final RoleMySQLRepository roleMySQLRepository;
    private final UserCredentialsMapper userCredentialsMapper;
    private final Mapper<Client, ClientEntity> mapper;
    private final Mapper<Person, PersonEntity> personMapper;

    public ClientPersistenceAdapter(ClientMySQLRepository clientMySQLRepository, PersonMySQLRepository personMySQLRepository,
                                    UserCredentialsRepository userCredentialsRepository, RoleMySQLRepository roleMySQLRepository,
                                    UserCredentialsMapper userCredentialsMapper, @Qualifier("clientMapper") Mapper<Client, ClientEntity> mapper,
                                    @Qualifier("personMapper") Mapper<Person, PersonEntity> personMapper) {
        this.clientMySQLRepository = clientMySQLRepository;
        this.personMySQLRepository = personMySQLRepository;
        this.userCredentialsRepository = userCredentialsRepository;
        this.roleMySQLRepository = roleMySQLRepository;
        this.userCredentialsMapper = userCredentialsMapper;
        this.mapper = mapper;
        this.personMapper = personMapper;
    }

    @Override
    @Transactional
    public Client create(UserStarterDTO userInfo) {
        RoleEntity role = this.roleMySQLRepository.findById(userInfo.getUserCredentials().getRole()).orElseThrow(); //TRHOW EX;
        PersonEntity p = this.personMapper.domainToEntity(userInfo.getPerson());
        PersonEntity personSaved = this.personMySQLRepository.save(p);
        UserCredentialsEntity u = this.userCredentialsMapper.domainReferenceToEntity(userInfo.getUserCredentials());
        u.setPersonEntity(personSaved);
        u.setRole(role);

        this.userCredentialsRepository.save(u);

        ClientEntity newClient = ClientEntity.builder()
                .person(personSaved)
                .build();
        return this.mapper.entityToDomain(this.clientMySQLRepository.save(newClient));

    }

    @Override
    public Client save(Client client) {
        ClientEntity clientEntity = this.clientMySQLRepository.save(this.mapper.domainToEntity(client));
        clientEntity.setId(client.getPerson().getId());
        return this.mapper.entityToDomain(clientEntity);
    }

    @Override
    public Client update() {
        return null;
    }

    @Override
    public String delete() {
        return null;
    }
}
