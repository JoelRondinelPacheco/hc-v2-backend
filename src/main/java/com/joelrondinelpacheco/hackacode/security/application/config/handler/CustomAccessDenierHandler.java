package com.joelrondinelpacheco.hackacode.security.application.config.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.joelrondinelpacheco.hackacode.common.application.dto.ApiError;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;

@Component
public class CustomAccessDenierHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        ApiError apiError = ApiError.builder()
                .backendMessage(accessDeniedException.getLocalizedMessage())
                //.url(request.getRequestURL().toString())
                //.method(request.getMethod())
                .message("Acceso denegado. No tienes los permisos necesarios para acceder a esta función. " +
                        "Por favor, contacta al administrador si crees que esto es un error.")
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.UNAUTHORIZED)
                .build();

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpStatus.FORBIDDEN.value());

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        String apiErrorAsJson = objectMapper.writeValueAsString(apiError);

        response.getWriter().write(apiErrorAsJson);
    }
}
