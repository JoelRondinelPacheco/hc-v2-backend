package com.joelrondinelpacheco.hackacode.common.handler;

import com.joelrondinelpacheco.hackacode.common.application.dto.ApiError;
import com.joelrondinelpacheco.hackacode.common.domain.EntityNotFoundException;
import com.joelrondinelpacheco.hackacode.common.domain.LoadKeysException;
import com.joelrondinelpacheco.hackacode.common.domain.ObjectNotValidException;
import com.joelrondinelpacheco.hackacode.common.application.utils.ApiErrorDefaultBuilder;
import com.joelrondinelpacheco.hackacode.security.domain.InvalidRefreshTokenException;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;


@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private final ApiErrorDefaultBuilder apiErrorBuilder;

    public GlobalExceptionHandler(ApiErrorDefaultBuilder apiErrorBuilder) {
        this.apiErrorBuilder = apiErrorBuilder;
    }

    //persistence

    @ExceptionHandler(InvalidRefreshTokenException.class)
    public ResponseEntity<ApiError> handleException(InvalidRefreshTokenException ex) {
        ApiError err = this.apiErrorBuilder.getApiError(ex);
        err.setMessage("Entity not found");
        err.setStatus(HttpStatus.NOT_FOUND);
        return  new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    //TODO CUSTOM EX
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiError> handleException(NoSuchElementException ex) {
        ApiError err = this.apiErrorBuilder.getApiError(ex);
        err.setMessage("Entity not found");
        err.setStatus(HttpStatus.NOT_FOUND);

        return  new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }
    //TODO CUSTOM EX
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiError> handleException(DataIntegrityViolationException ex) {
        ApiError err = this.apiErrorBuilder.getApiError(ex);
        err.setMessage("Duplicated value");
        err.setStatus(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }
    //persistence

    @ExceptionHandler(ObjectNotValidException.class)
    public ResponseEntity<ApiError> handleException(ObjectNotValidException ex) {
        return ResponseEntity
                .badRequest()
                .body(ex.getApiError());
    }

    @ExceptionHandler(LoadKeysException.class)
    public ResponseEntity<ApiError> handleException(LoadKeysException ex) {

        ApiError err = this.apiErrorBuilder.getApiError(ex);
        err.setMessage("Error keys");
        err.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<ApiError>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    //TODO CUSTOM EX
    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<ApiError> handleException(ExpiredJwtException ex) {
        ApiError err = this.apiErrorBuilder.getApiError(ex);
        err.setMessage("Auth token expired");
        err.setStatus(HttpStatus.FORBIDDEN);
        return new ResponseEntity<>(err, HttpStatus.FORBIDDEN);
    }


    //token vencido 501

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex) {
        ApiError err = this.apiErrorBuilder.getApiError(ex);
        err.setMessage("Unknow ex");
        err.setStatus(HttpStatus.BAD_REQUEST);
        return ResponseEntity.badRequest().build();
    }
}
