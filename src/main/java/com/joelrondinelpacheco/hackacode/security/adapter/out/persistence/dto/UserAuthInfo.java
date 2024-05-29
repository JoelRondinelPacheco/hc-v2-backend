package com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.dto;

import com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.entity.RoleEntity;
import org.springframework.beans.factory.annotation.Value;

public interface  UserAuthInfo {
    @Value("#{target.person.email}")
    String getEmail();
    String getPassword();
    @Value("#{target.person.role}")
    RoleEntity getRole();
    //Long getRole();
}
