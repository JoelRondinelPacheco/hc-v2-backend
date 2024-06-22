package com.joelrondinelpacheco.hackacode.security.application.config.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.joelrondinelpacheco.hackacode.common.application.dto.ApiError;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
/*
    @Autowired
    private AccessDeniedHandler accessDeniedHandler;
*/
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        System.out.println(authException);

        String backendMessage = "";
        if (authException.getCause() != null) {
            backendMessage = authException.getCause().getMessage();
        } else {
            backendMessage = "No throwable";
        }
        //accessDeniedHandler.handle(request, response, new AccessDeniedException(authException.getMessage()));
        ApiError err = ApiError.builder()
                .status(HttpStatus.valueOf(response.getStatus()))
                .timestamp(LocalDateTime.now())
                .message(authException.getMessage())
                .backendMessage(backendMessage)
                .build();

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(response.getStatus());
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        String apiErrorAsJSON = objectMapper.writeValueAsString(err);
        response.getWriter().write(apiErrorAsJSON);
        //"Access Denied asdasd, lanza el token"
    }
}
