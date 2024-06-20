package com.joelrondinelpacheco.hackacode.common.application.validators;

import com.joelrondinelpacheco.hackacode.common.application.dto.ApiError;
import com.joelrondinelpacheco.hackacode.common.application.dto.ApiSubError;
import com.joelrondinelpacheco.hackacode.common.application.exceptions.ObjectNotValidException;
import io.jsonwebtoken.lang.Collections;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ObjectsValidator<T> {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    public void validate(T objectToValidate) {
        Set<ConstraintViolation<T>> violations = validator.validate(objectToValidate);

        if (!violations.isEmpty()) {
            List<ApiSubError> subErrors = violations.stream()
                    .map(v -> ApiSubError
                            .builder()
                            .field(v.getPropertyPath().toString())
                            .message(v.getMessage())
                            .rejectedValue(v.getInvalidValue())
                            .build()
                    ).toList();
            ApiError apiError = ApiError.builder()
                    .status(HttpStatus.BAD_REQUEST)
                    .message("Validation errors")
                    .timestamp(LocalDateTime.now())
                    .subErrors(subErrors)
                    .build();

            throw new ObjectNotValidException(apiError);
        }
    }
}
