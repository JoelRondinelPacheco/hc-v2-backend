package com.joelrondinelpacheco.hackacode.common.handler;

import com.joelrondinelpacheco.hackacode.common.application.dto.ApiError;
import com.joelrondinelpacheco.hackacode.common.application.utils.ApiErrorDefaultBuilder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;


public class PersistenceExceptionHandler{

    //todo multiple restControllerAdvice

    private final ApiErrorDefaultBuilder apiErrorBuilder;

    public PersistenceExceptionHandler(ApiErrorDefaultBuilder apiErrorBuilder) {
        this.apiErrorBuilder = apiErrorBuilder;
    }
/*
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiError> handleException(DataIntegrityViolationException ex) {
        System.out.println("En el handler");
        System.out.println(ex);
        ApiError err = this.apiErrorBuilder.getApiError(ex);
        err.setMessage("Duplicated value");
        err.setStatus(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }*/

}
