package com.joelrondinelpacheco.hackacode.common.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Data
@AllArgsConstructor
public class ApiErrorValidation extends ApiError{
    private List<ApiSubError> subErrors;

}
