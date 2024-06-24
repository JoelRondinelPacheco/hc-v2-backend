package com.joelrondinelpacheco.hackacode.common.application.utils;

import com.joelrondinelpacheco.hackacode.common.application.dto.ApiError;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ApiErrorDefaultBuilderImpl implements ApiErrorDefaultBuilder{
    @Override
    public ApiError getApiError(Exception ex) {
        return ApiError.builder()
                .timestamp(LocalDateTime.now())
                .backendMessage(ex.getMessage())
                .build();
    }
}
