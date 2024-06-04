package com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.mapper;

import com.joelrondinelpacheco.hackacode.common.adapter.Mapper;
import com.joelrondinelpacheco.hackacode.security.adapter.out.persistence.entity.UserCredentialsEntity;
import com.joelrondinelpacheco.hackacode.security.application.entity.CustomUserDetails;
import com.joelrondinelpacheco.hackacode.security.domain.UserCredentials;

public interface UserCredentialsMapper extends Mapper<UserCredentials, UserCredentialsEntity> {
    CustomUserDetails entityToCustomUserDetails(UserCredentialsEntity userCredentials);
}
