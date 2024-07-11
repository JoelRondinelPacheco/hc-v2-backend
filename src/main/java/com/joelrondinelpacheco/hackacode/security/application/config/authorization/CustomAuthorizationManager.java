package com.joelrondinelpacheco.hackacode.security.application.config.authorization;

import com.joelrondinelpacheco.hackacode.security.application.entity.CustomUserDetails;
import com.joelrondinelpacheco.hackacode.security.application.usecases.CustomUsersDetailsService;
import com.joelrondinelpacheco.hackacode.security.application.usecases.OperationService;
import com.joelrondinelpacheco.hackacode.security.domain.Operation;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Component
public class CustomAuthorizationManager implements AuthorizationManager<RequestAuthorizationContext> {

    @Autowired
    private OperationService operationService;
    @Autowired
    private CustomUsersDetailsService userService;

    @Override
    public AuthorizationDecision check(Supplier<Authentication> authentication, RequestAuthorizationContext requestContext) {
        HttpServletRequest request = requestContext.getRequest();

        String url = extractUrl(request);
        String httpMethod = request.getMethod();
        boolean isPublic = isPublic(url, httpMethod);
        if(isPublic){
            return new AuthorizationDecision(true);
        }
/*
        if (this.isPermitAllRole(authentication)) {
            return new AuthorizationDecision(true);
        }*/

        boolean isGranted = isGranted(url, httpMethod, authentication.get());
        return new AuthorizationDecision(isGranted);
    }

    private boolean isPermitAllRole(Supplier<Authentication> authentication) {
        CustomUserDetails user = this.getUserDetailsFromAuthentication(authentication.get());
        //TODO ALL PERMISIONS ROLE
        return user.getRole().getName().equals("OWNER");
    }

    private boolean isGranted(String url, String httpMethod, Authentication authentication) {

        //TODO HANDLE EXCEPTION IN ADVICER
        if( authentication == null || !(authentication instanceof UsernamePasswordAuthenticationToken)){
            throw new AuthenticationCredentialsNotFoundException("Employee not logged in");
        }

        List<Operation> operations = this.obtainOperations(authentication);

        boolean isGranted = operations.stream().anyMatch(getOperationPredicate(url, httpMethod));

        return isGranted;
    }

    private static Predicate<Operation> getOperationPredicate(String url, String httpMethod) {
        return operation -> {

            String basePath = operation.getModule().getBasePath();

            Pattern pattern = Pattern.compile(basePath.concat(operation.getPath()));
            Matcher matcher = pattern.matcher(url);

            return matcher.matches() && operation.getHttpMethod().equals(httpMethod);
        };
    }

    private List<Operation> obtainOperations(Authentication authentication) {

        CustomUserDetails user = this.getUserDetailsFromAuthentication(authentication);

        return user.getRole().getPermissions().stream()
                .map(grantedPermission -> grantedPermission.getOperation())
                .collect(Collectors.toList());

    }

    private CustomUserDetails getUserDetailsFromAuthentication(Authentication auth) {
        UsernamePasswordAuthenticationToken authToken = (UsernamePasswordAuthenticationToken) auth;
        String username = (String) authToken.getPrincipal();
        return this.userService.getUserDetails(username);

    }

    private boolean isPublic(String url, String httpMethod) {

        List<Operation> publicAccessEndpoints = this.operationService.findByPublicAccess();

        boolean isPublic = publicAccessEndpoints.stream().anyMatch(getOperationPredicate(url, httpMethod));

        return isPublic;
    }

    private String extractUrl(HttpServletRequest request) {

        String contextPath = request.getContextPath();
        String url = request.getRequestURI();
        url = url.replace(contextPath, "");

        return url;
    }

}
