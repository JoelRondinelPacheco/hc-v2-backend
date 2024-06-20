package com.joelrondinelpacheco.hackacode.common.handler;

import com.joelrondinelpacheco.hackacode.common.application.dto.ApiError;
import com.joelrondinelpacheco.hackacode.common.application.dto.ApiErrorValidation;
import com.joelrondinelpacheco.hackacode.common.application.exceptions.LoadKeysException;
import com.joelrondinelpacheco.hackacode.common.application.exceptions.ObjectNotValidException;
import io.jsonwebtoken.ExpiredJwtException;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(ObjectNotValidException.class)
    public ResponseEntity<ApiError> handleException(ObjectNotValidException ex) {
        return ResponseEntity
                .badRequest()
                .body(ex.getApiError());
    }

    @ExceptionHandler(LoadKeysException.class)
    public ResponseEntity<ApiError> handleException(LoadKeysException ex) {

        ApiError err = ApiError.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .message("Error keys")
                .backendMessage(ex.getMessage())
                .build();

        return new ResponseEntity<ApiError>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<ApiError> handleException(ExpiredJwtException ex) {
        ApiError err = ApiError.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.FORBIDDEN)
                .message("Auth token expired")
                .backendMessage(ex.getMessage())
                .build();

        return new ResponseEntity<>(err, HttpStatus.FORBIDDEN);
    }

    //token vencido 501

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex) {
        return ResponseEntity.badRequest().build();
    }
}
