package com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.repository;

import com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.dto.UserAuthInfo;
import com.joelrondinelpacheco.hackacode.user.adapter.out.persistence.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersAuthInfoRepository extends JpaRepository<UserEntity, Long> {

    //@Query(value = "SELECT p.email AS email, u.password AS password, p.role_id AS role FROM user_table u JOIN person p ON u.person_id = p.id WHERE p.email = :email", nativeQuery = true)
    //Optional<UserCredentials> byEmail(String email);
    Optional<UserAuthInfo> findByPerson_Email(String email);

}
