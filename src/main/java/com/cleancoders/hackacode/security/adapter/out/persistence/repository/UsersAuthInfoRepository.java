package com.cleancoders.hackacode.security.adapter.out.persistence.repository;

import com.cleancoders.hackacode.security.adapter.out.persistence.dto.UserAuthInfo;
import com.cleancoders.hackacode.user.adapter.out.persistence.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersAuthInfoRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserAuthInfo> findByPerson_Email(String email);

}
