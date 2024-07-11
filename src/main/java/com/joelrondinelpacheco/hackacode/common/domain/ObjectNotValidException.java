package com.joelrondinelpacheco.hackacode.common.domain;

import com.joelrondinelpacheco.hackacode.common.application.dto.ApiError;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ObjectNotValidException extends RuntimeException {
    private ApiError apiError;
}
