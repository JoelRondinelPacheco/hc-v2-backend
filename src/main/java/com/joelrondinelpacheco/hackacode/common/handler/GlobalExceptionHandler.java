package com.joelrondinelpacheco.hackacode.common.handler;

import com.joelrondinelpacheco.hackacode.common.application.dto.ApiError;
import com.joelrondinelpacheco.hackacode.common.application.exceptions.ObjectNotValidException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex) {
        return ResponseEntity.badRequest().build();
    }
    @ExceptionHandler(ObjectNotValidException.class)
    public ResponseEntity<ApiError> handleException(ObjectNotValidException ex) {
        return ResponseEntity
                .badRequest()
                .body(ex.getApiError());
    }
}
