package com.joelrondinelpacheco.hackacode.common.application.utils;

import com.joelrondinelpacheco.hackacode.common.application.dto.ApiError;

public interface ApiErrorDefaultBuilder {

    ApiError getApiError(Exception ex);
}
