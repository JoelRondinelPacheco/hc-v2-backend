package com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.mapper;

import com.joelrondinelpacheco.hackacode.common.PersistenceMapper;
import com.joelrondinelpacheco.hackacode.common.adapter.Mapper;
import com.joelrondinelpacheco.hackacode.person.adapter.out.persistence.PersonEntity;
import com.joelrondinelpacheco.hackacode.person.domain.Person;
import com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.entity.UserCredentialsEntity;
import com.joelrondinelpacheco.hackacode.security.application.entity.CustomUserDetails;
import com.joelrondinelpacheco.hackacode.security.application.utilities.AuthUtils;
import com.joelrondinelpacheco.hackacode.security.domain.Role;
import com.joelrondinelpacheco.hackacode.security.domain.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;


@PersistenceMapper
public class UserCredentialsMapperImpl implements UserCredentialsMapper{

    @Qualifier("personMapper")
    private final Mapper<Person, PersonEntity> personMapper;
    private final PermissionsRoleMapper roleMapper;
    private final AuthUtils authUtils;

    @Autowired
    public UserCredentialsMapperImpl(Mapper<Person, PersonEntity> personMapper, PermissionsRoleMapper roleMapper, AuthUtils authUtils) {
        this.personMapper = personMapper;
        this.roleMapper = roleMapper;
        this.authUtils = authUtils;
    }

    @Override
    public UserCredentials entityToDomain(UserCredentialsEntity userCredentialsEntity) {
        return null;
    }

    @Override
    public UserCredentialsEntity domainToEntity(UserCredentials userCredentials) {
        return UserCredentialsEntity.builder()
                .id(userCredentials.getId())
                .personEntity(
                        this.personMapper.domainToEntity(userCredentials.getPerson())
                )
                .password(userCredentials.getPassword())
                .accountNonExpired(userCredentials.isAccountNonExpired())
                .accountNonLocked(userCredentials.isAccountNonLocked())
                .credentialsNonExpired(userCredentials.isAccountNonExpired())
                .enabled(userCredentials.isEnabled())
                .emailToken(userCredentials.getEmailToken())
                .role(
                        this.roleMapper.domainToEntityRole(userCredentials.getRole())
                )
                .build();
    }

    @Override
    public CustomUserDetails entityToCustomUserDetails(UserCredentialsEntity userCredentials) {

        Role role = roleMapper.entityToDomainRole(userCredentials.getRole());
        List<SimpleGrantedAuthority> authorities = this.authUtils.getAuthorities(role);

        return CustomUserDetails.builder()
                .id(userCredentials.getId())
                .person(
                        this.personMapper.entityToDomain(userCredentials.getPersonEntity())
                )
                .password(userCredentials.getPassword())
                .accountNonExpired(userCredentials.isAccountNonExpired())
                .accountNonLocked(userCredentials.isAccountNonLocked())
                .credentialsNonExpired(userCredentials.isAccountNonExpired())
                .enabled(userCredentials.isEnabled())
                .emailToken(userCredentials.getEmailToken())
                .role(role)
                .authorities(authorities)
                .build();
    }
}
