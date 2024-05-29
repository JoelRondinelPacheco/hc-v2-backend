package com.joelrondinelpacheco.hackacode.security.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class GrantedPermission {
    private Long id;
    private Operation operation;

}
