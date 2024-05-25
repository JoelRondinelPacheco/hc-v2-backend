package com.cleancoders.hackacode.security.adapter.out.persistence.repository;

import com.cleancoders.hackacode.security.adapter.out.persistence.dto.UserAuthInfo;
import com.cleancoders.hackacode.user.adapter.out.persistence.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsersAuthInfoRepository extends JpaRepository<UserEntity, Long> {

    //@Query(value = "SELECT p.email AS email, u.password AS password, p.role_id AS role FROM user_table u JOIN person p ON u.person_id = p.id WHERE p.email = :email", nativeQuery = true)
    //Optional<UserAuthInfo> byEmail(String email);
    Optional<UserAuthInfo> findByPerson_Email(String email);

}
