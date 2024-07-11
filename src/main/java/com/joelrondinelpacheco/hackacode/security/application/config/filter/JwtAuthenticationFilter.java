package com.joelrondinelpacheco.hackacode.security.application.config.filter;

import com.joelrondinelpacheco.hackacode.security.application.entity.CustomUserDetails;
import com.joelrondinelpacheco.hackacode.security.application.usecases.CookiesJWTUseCase;
import com.joelrondinelpacheco.hackacode.security.application.usecases.CustomUsersDetailsService;
import com.joelrondinelpacheco.hackacode.security.application.usecases.JwtTokenService;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {


    private final AuthenticationEntryPoint authenticationEntryPoint;
    private final JwtTokenService jwtTokenService;
    private final CustomUsersDetailsService customUserService;
    private final CookiesJWTUseCase cookiesJWTUseCase;

    public JwtAuthenticationFilter(AuthenticationEntryPoint authenticationEntryPoint, JwtTokenService jwtTokenService, CustomUsersDetailsService customUserService, CookiesJWTUseCase cookiesJWTUseCase) {
        this.authenticationEntryPoint = authenticationEntryPoint;
        this.jwtTokenService = jwtTokenService;
        this.customUserService = customUserService;
        this.cookiesJWTUseCase = cookiesJWTUseCase;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // WITH BEARER
        String jwt = this.jwtTokenService.extractJwtFromRequest(request);
        if (jwt == null || !StringUtils.hasText(jwt)) {
            filterChain.doFilter(request, response);
            return;
        }

        // WITH COOKIES
/*
        String jwt = this.cookiesJWTUseCase.getAuthJwtFromRequest(request);
        if (jwt == null || !StringUtils.hasText(jwt)) {
            filterChain.doFilter(request, response);
            return;
        }*/

    //TODO VERIFICAR QUE SEA AUTH TOKEN
        try {
            String username = this.jwtTokenService.extractUsername(jwt);
            CustomUserDetails user = this.customUserService.getUserDetails(username);

            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    username, null, user.getAuthorities()
            );

            authToken.setDetails(new WebAuthenticationDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authToken);

            filterChain.doFilter(request, response);
        } catch (ExpiredJwtException ex) {
            response.setStatus(HttpStatus.FORBIDDEN.value());
            authenticationEntryPoint.commence(request, response, new CredentialsExpiredException("JWT token expired msg", ex));
        }
        catch (JwtException ex) {
            //TODO delete refresh token?
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            authenticationEntryPoint.commence(request, response, new BadCredentialsException("Invalid JWT token", ex));
        }
    }
}
